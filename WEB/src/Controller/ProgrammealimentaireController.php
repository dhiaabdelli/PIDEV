<?php

namespace App\Controller;

use App\Entity\Profile;
use App\Entity\Programmealimentaire;
use App\Form\ProgrammealimentaireType;
use App\Repository\ProfileRepository;
use App\Repository\ProgrammealimentaireRepository;
use Doctrine\Persistence\ManagerRegistry;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;

/**
 * @Route("/programmealimentaire")
 */
class ProgrammealimentaireController extends AbstractController
{
    /**
     * @Route("/", name="programmealimentaire_index", methods={"GET"})
     */
    public function index(): Response
    {

        $programmealimentaires = $this->getDoctrine()
            ->getRepository(Programmealimentaire::class)
            ->findAll();

        return $this->render('programmealimentaire/index.html.twig', [
            'programmealimentaires' => $programmealimentaires,
        ]);
    }

    /**
     * @Route("/new", name="programmealimentaire_new", methods={"GET","POST"})
     */
    public function new(Request $request): Response
    {
        $programmealimentaire = new Programmealimentaire();
        $form = $this->createForm(ProgrammealimentaireType::class, $programmealimentaire);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $entityManager = $this->getDoctrine()->getManager();
            $entityManager->persist($programmealimentaire);
            $entityManager->flush();

            return $this->redirectToRoute('programmealimentaire_index');
        }

        return $this->render('programmealimentaire/new.html.twig', [
            'programmealimentaire' => $programmealimentaire,
            'form' => $form->createView(),
        ]);
    }

    /**
     * @Route("/{idprofile}", name="programmealimentaire_show", methods={"GET"})
     */
    public function show(Programmealimentaire $programmealimentaire): Response
    {
        return $this->render('programmealimentaire/show.html.twig', [
            'programmealimentaire' => $programmealimentaire,
        ]);
    }

    /**
     * @Route("/{idprofile}/edit", name="programmealimentaire_edit", methods={"GET","POST"})
     */
    public function edit(Request $request, Programmealimentaire $programmealimentaire): Response
    {
        $form = $this->createForm(ProgrammealimentaireType::class, $programmealimentaire);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $this->getDoctrine()->getManager()->flush();

            return $this->redirectToRoute('programmealimentaire_index');
        }

        return $this->render('programmealimentaire/edit.html.twig', [
            'programmealimentaire' => $programmealimentaire,
            'form' => $form->createView(),
        ]);
    }

    /**
     * @Route("/{idprofile}", name="programmealimentaire_delete", methods={"POST"})
     */
    public function delete(Request $request, Programmealimentaire $programmealimentaire): Response
    {
        if ($this->isCsrfTokenValid('delete'.$programmealimentaire->getIdprofile()->getId(), $request->request->get('_token'))) {
            $entityManager = $this->getDoctrine()->getManager();
            $entityManager->remove($programmealimentaire);
            $entityManager->flush();
        }

        return $this->redirectToRoute('programmealimentaire_index');
    }

    /**
     * @Route("/calculerProgrammeAlimentaire/{idp}", name="calculerProgrammeAlimentaire", methods={"GET","POST"})
     */
    public function calculerProgrammeAlimentaire($idp, ProfileRepository $repository): Response
    {
        $pr = $repository->find($idp);
        $pa = new Programmealimentaire();
        $pa->setIdprofile($pr);
        if($pr->getSexe() == 0){
            $pa->setBmr(round((13.397 * $pr->getPoids() + 4.799 * $pr->getTaille()- 5.677 * $pr->getAge() + 88.362)));
        }
        if($pr->getSexe() == 1){
            $pa->setBmr(round((9.247 * $pr->getPoids() + 3.098 * $pr->getTaille() - 4.330 * $pr->getAge() + 447.593)));
        }
        if($pr->getObjectif() == 0){
            $pa->setCalRequis($pa->getBmr() - 500);
            $pa->setCarbsRequis($pa->getCalRequis() / 2 / 4);
            $pa->setFatsRequis($pa->getCalRequis() * 20 / 100 / 9);
            $pa->setProteinsRequis($pa->getCalRequis() * 30 / 100 / 4);
        }
        if($pr->getObjectif() == 1){
            $pa->setCalRequis($pa->getBmr() + 500);
            $pa->setCarbsRequis($pa->getCalRequis() * 40 / 100 / 4);
            $pa->setFatsRequis($pa->getCalRequis() * 20 / 100 / 9);
            $pa->setProteinsRequis($pa->getCalRequis() * 40 / 100 / 4);
        }
        $entityManager = $this->getDoctrine()->getManager();
        $entityManager->persist($pa);
        $entityManager->flush();
        return $this->redirectToRoute('associerAliments',['idp'=>$idp]);
    }

}
