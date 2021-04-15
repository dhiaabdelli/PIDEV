<?php

namespace App\Controller;

use App\Entity\Exerciceassocie;
use App\Form\ExerciceassocieType;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;

/**
 * @Route("/exerciceassocie")
 */
class ExerciceassocieController extends AbstractController
{
    /**
     * @Route("/", name="exerciceassocie_index", methods={"GET"})
     */
    public function index(): Response
    {
        $exerciceassocies = $this->getDoctrine()
            ->getRepository(Exerciceassocie::class)
            ->findAll();

        return $this->render('exerciceassocie/index.html.twig', [
            'exerciceassocies' => $exerciceassocies,
        ]);
    }

    /**
     * @Route("/new", name="exerciceassocie_new", methods={"GET","POST"})
     */
    public function new(Request $request): Response
    {
        $exerciceassocie = new Exerciceassocie();
        $form = $this->createForm(ExerciceassocieType::class, $exerciceassocie);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $entityManager = $this->getDoctrine()->getManager();
            $entityManager->persist($exerciceassocie);
            $entityManager->flush();

            return $this->redirectToRoute('exerciceassocie_index');
        }

        return $this->render('exerciceassocie/new.html.twig', [
            'exerciceassocie' => $exerciceassocie,
            'form' => $form->createView(),
        ]);
    }

    /**
     * @Route("/{idexassocier}", name="exerciceassocie_show", methods={"GET"})
     */
    public function show(Exerciceassocie $exerciceassocie): Response
    {
        return $this->render('exerciceassocie/show.html.twig', [
            'exerciceassocie' => $exerciceassocie,
        ]);
    }

    /**
     * @Route("/{idexassocier}/edit", name="exerciceassocie_edit", methods={"GET","POST"})
     */
    public function edit(Request $request, Exerciceassocie $exerciceassocie): Response
    {
        $form = $this->createForm(ExerciceassocieType::class, $exerciceassocie);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $this->getDoctrine()->getManager()->flush();

            return $this->redirectToRoute('exerciceassocie_index');
        }

        return $this->render('exerciceassocie/edit.html.twig', [
            'exerciceassocie' => $exerciceassocie,
            'form' => $form->createView(),
        ]);
    }

    /**
     * @Route("/{idexassocier}", name="exerciceassocie_delete", methods={"POST"})
     */
    public function delete(Request $request, Exerciceassocie $exerciceassocie): Response
    {
        if ($this->isCsrfTokenValid('delete'.$exerciceassocie->getIdexassocier(), $request->request->get('_token'))) {
            $entityManager = $this->getDoctrine()->getManager();
            $entityManager->remove($exerciceassocie);
            $entityManager->flush();
        }

        return $this->redirectToRoute('exerciceassocie_index');
    }
}
