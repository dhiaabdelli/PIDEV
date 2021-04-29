<?php

namespace App\Controller;

use App\Entity\Aliment;
use App\Form\AlimentType;
use App\Repository\ProfileRepository;
use App\Repository\ProgrammealimentaireRepository;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;

/**
 * @Route("/aliment")
 */
class AlimentController extends AbstractController
{
    /**
     * @Route("/", name="aliment_index", methods={"GET"})
     */
    public function index(): Response
    {
        $aliments = $this->getDoctrine()
            ->getRepository(Aliment::class)
            ->findAll();

        return $this->render('aliment/index.html.twig', [
            'aliments' => $aliments,
        ]);
    }

    /**
     * @Route("/new", name="aliment_new", methods={"GET","POST"})
     */
    public function new(Request $request): Response
    {
        $aliment = new Aliment();
        $form = $this->createForm(AlimentType::class, $aliment);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $entityManager = $this->getDoctrine()->getManager();
            if($aliment->getProteins() > $aliment->getCarbs()){
                if($aliment->getProteins() > $aliment->getFats()){
                    $aliment->setType(0);
                }else{
                    $aliment->setType(2);
                }
            }else{
                if($aliment->getCarbs() > $aliment->getFats()){
                    $aliment->setType(1);
                }else{
                    $aliment->setType(2);
                }
            }
            $entityManager->persist($aliment);
            $entityManager->flush();

            return $this->redirectToRoute('aliment_index');
        }

        return $this->render('aliment/new.html.twig', [
            'aliment' => $aliment,
            'form' => $form->createView(),
        ]);
    }

    /**
     * @Route("/{id}", name="aliment_show", methods={"GET"})
     */
    public function show(Aliment $aliment): Response
    {
        return $this->render('aliment/show.html.twig', [
            'aliment' => $aliment,
        ]);
    }

    /**
     * @Route("/{id}/edit", name="aliment_edit", methods={"GET","POST"})
     */
    public function edit(Request $request, Aliment $aliment): Response
    {
        $form = $this->createForm(AlimentType::class, $aliment);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            if($aliment->getProteins() > $aliment->getCarbs()){
                if($aliment->getProteins() > $aliment->getFats()){
                    $aliment->setType(0);
                }else{
                    $aliment->setType(2);
                }
            }else{
                if($aliment->getCarbs() > $aliment->getFats()){
                    $aliment->setType(1);
                }else{
                    $aliment->setType(2);
                }
            }
            $this->getDoctrine()->getManager()->flush();

            return $this->redirectToRoute('aliment_index');
        }

        return $this->render('aliment/edit.html.twig', [
            'aliment' => $aliment,
            'form' => $form->createView(),
        ]);
    }

    /**
     * @Route("/{id}", name="aliment_delete", methods={"POST"})
     */
    public function delete(Request $request, Aliment $aliment): Response
    {
       if ($this->isCsrfTokenValid('delete'.$aliment->getId(), $request->request->get('_token'))) {
            $entityManager = $this->getDoctrine()->getManager();
            $entityManager->remove($aliment);
            $entityManager->flush();
        }
        return $this->redirectToRoute('aliment_index');
    }

}

/*
       , ProfileRepository $repository)
     return $this->redirectToRoute('calculerProgrammeAlimentaire',['idp'=>$profile->getId()]);
     */
