<?php

namespace App\Controller;

use App\Entity\Alimentassocie;
use App\Form\AlimentassocieType;
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
     * @Route("/{idaliment}", name="alimentassocie_show", methods={"GET"})
     */
    public function show(Alimentassocie $alimentassocie): Response
    {
        return $this->render('alimentassocie/show.html.twig', [
            'alimentassocie' => $alimentassocie,
        ]);
    }

    /**
     * @Route("/{idaliment}/edit", name="alimentassocie_edit", methods={"GET","POST"})
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
     * @Route("/{idaliment}", name="alimentassocie_delete", methods={"POST"})
     */
    public function delete(Request $request, Alimentassocie $alimentassocie): Response
    {
        if ($this->isCsrfTokenValid('delete'.$alimentassocie->getIdaliment(), $request->request->get('_token'))) {
            $entityManager = $this->getDoctrine()->getManager();
            $entityManager->remove($alimentassocie);
            $entityManager->flush();
        }

        return $this->redirectToRoute('alimentassocie_index');
    }
}
