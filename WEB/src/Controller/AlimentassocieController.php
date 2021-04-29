<?php

namespace App\Controller;

use App\Entity\Aliment;
use App\Entity\Alimentassocie;
use App\Entity\Profile;
use App\Entity\Programmealimentaire;
use App\Form\AlimentassocieType;
use App\Repository\AlimentassocieRepository;
use App\Repository\ProfileRepository;
use App\Repository\ProgrammealimentaireRepository;
use App\Repository\AlimentRepository;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;

/**
 * @Route("/alimentassocie")
 */
class AlimentassocieController extends AbstractController
{
    /**
     * @Route("/", name="alimentassocie_index", methods={"GET"})
     */
    public function index(): Response
    {
        $alimentassocies = $this->getDoctrine()
            ->getRepository(Alimentassocie::class)
            ->findAll();

        return $this->render('alimentassocie/index.html.twig', [
            'alimentassocies' => $alimentassocies,
        ]);
    }

    /**
     * @Route("/new", name="alimentassocie_new", methods={"GET","POST"})
     */
    public function new(Request $request): Response
    {
        $alimentassocie = new Alimentassocie();
        $form = $this->createForm(AlimentassocieType::class, $alimentassocie);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $entityManager = $this->getDoctrine()->getManager();
            $entityManager->persist($alimentassocie);
            $entityManager->flush();
            return $this->redirectToRoute('alimentassocie_index');
        }

        return $this->render('alimentassocie/new.html.twig', [
            'alimentassocie' => $alimentassocie,
            'form' => $form->createView(),
        ]);
    }

    /**
     * @Route("/{id}", name="alimentassocie_show", methods={"GET"})
     */
    public function show(Alimentassocie $alimentassocie): Response
    {
        return $this->render('alimentassocie/show.html.twig', [
            'alimentassocie' => $alimentassocie,
        ]);
    }

    /**
     * @Route("/{id}/edit", name="alimentassocie_edit", methods={"GET","POST"})
     */
    public function edit(Request $request, Alimentassocie $alimentassocie): Response
    {
        $form = $this->createForm(AlimentassocieType::class, $alimentassocie);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $this->getDoctrine()->getManager()->flush();

            return $this->redirectToRoute('alimentassocie_index');
        }

        return $this->render('alimentassocie/edit.html.twig', [
            'alimentassocie' => $alimentassocie,
            'form' => $form->createView(),
        ]);
    }

    /**
     * @Route("/{id}", name="alimentassocie_delete", methods={"POST"})
     */
    public function delete(Request $request, Alimentassocie $alimentassocie): Response
    {
        if ($this->isCsrfTokenValid('delete'.$alimentassocie->getId(), $request->request->get('_token'))) {
            $entityManager = $this->getDoctrine()->getManager();
            $entityManager->remove($alimentassocie);
            $entityManager->flush();
        }

        return $this->redirectToRoute('alimentassocie_index');
    }

    /**
     * @Route("/associerAliments/{idp}", name="associerAliments", methods={"GET","POST"})
     * @param $idp
     * @param AlimentassocieRepository $aaRep
     * @param AlimentRepository $aRep
     * @param ProgrammealimentaireRepository $paRep
     * @param ProfileRepository $pRep
     * @return Response
     */
     public function associerAliments($idp, AlimentassocieRepository $aaRep, AlimentRepository $aRep, ProgrammealimentaireRepository $paRep, ProfileRepository $pRep): Response
     {
         $ppp = $pRep->find($idp);
        $progalim = $paRep->findOneBy(['idprofile'=> $idp]);
        $nbRepas = $pRep->find($idp)->getNbrepas();
        $proteinsParRepas = $progalim->getProteinsrequis() / $nbRepas;
        $fatsParRepas = $progalim->getFatsrequis() / $nbRepas;
        $carbsParRepas = $progalim->getCarbsrequis() / $nbRepas;
        for($i = 1; $i <= $nbRepas; $i++){
            $type0set = 0;
            $type1set = 0;
            $type2set = 0;
            for($j = 0; $j < 3; $j++){
                $AA = new Alimentassocie();
                $AA->setIdprofile($ppp);
                $AA->setRepas($i);
                $aliments = $aRep->findAll();
                foreach($aliments as $aliment){
                    $alimentDejaAssocie = $aaRep->findOneBy(['idaliment'=> $aliment->getId(), 'idprofile'=> $idp]);;
                    if($alimentDejaAssocie == NULL){
                        if($aliment->getType() == 0 && $type0set == 0 && $j == 0){
                            $AA->setIdaliment($aliment);
                            $AA->setQte($proteinsParRepas * 100 / $aliment->getProteins());
                            $type0set = 1;
                        }
                        if($aliment->getType() == 1 && $type1set == 0 && $j == 1){
                            $AA->setIdaliment($aliment);
                            $AA->setQte($carbsParRepas * 100 / $aliment->getCarbs());
                            $type1set = 1;
                        }
                        if($aliment->getType() == 2 && $type2set == 0 && $j == 2){
                            $AA->setIdaliment($aliment);
                            $AA->setQte($fatsParRepas * 100 / $aliment->getFats());
                            $type2set = 1;
                        }
                    }
                    if($type0set && $type1set && $type2set){
                        break;
                    }
                }
                $entityManager = $this->getDoctrine()->getManager();
                $entityManager->persist($AA);
                $entityManager->flush();
            }
        }
        return $this->redirectToRoute('alimentassocie_index');
    }

}
