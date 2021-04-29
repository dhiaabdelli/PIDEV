<?php

namespace App\Controller;

use App\Entity\Produitscommand;
use App\Form\ProduitscommandType;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;

/**
 * @Route("/produitscommand")
 */
class ProduitscommandController extends AbstractController
{
    /**
     * @Route("/", name="produitscommand_index", methods={"GET"})
     */
    public function index(): Response
    {
        $produitscommands = $this->getDoctrine()
            ->getRepository(Produitscommand::class)
            ->findAll();

        return $this->render('produitscommand/index.html.twig', [
            'produitscommands' => $produitscommands,
        ]);
    }

    /**
     * @Route("/new", name="produitscommand_new", methods={"GET","POST"})
     */
    public function new(Request $request): Response
    {
        $produitscommand = new Produitscommand();
        $form = $this->createForm(ProduitscommandType::class, $produitscommand);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $entityManager = $this->getDoctrine()->getManager();
            $entityManager->persist($produitscommand);
            $entityManager->flush();

            return $this->redirectToRoute('produitscommand_index');
        }

        return $this->render('produitscommand/new.html.twig', [
            'produitscommand' => $produitscommand,
            'form' => $form->createView(),
        ]);
    }

    /**
     * @Route("/{id}", name="produitscommand_show", methods={"GET"})
     */
    public function show(Produitscommand $produitscommand): Response
    {
        return $this->render('produitscommand/show.html.twig', [
            'produitscommand' => $produitscommand,
        ]);
    }

    /**
     * @Route("/{id}/edit", name="produitscommand_edit", methods={"GET","POST"})
     */
    public function edit(Request $request, Produitscommand $produitscommand): Response
    {
        $form = $this->createForm(ProduitscommandType::class, $produitscommand);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $this->getDoctrine()->getManager()->flush();

            return $this->redirectToRoute('produitscommand_index');
        }

        return $this->render('produitscommand/edit.html.twig', [
            'produitscommand' => $produitscommand,
            'form' => $form->createView(),
        ]);
    }

    /**
     * @Route("/{id}", name="produitscommand_delete", methods={"POST"})
     */
    public function delete(Request $request, Produitscommand $produitscommand): Response
    {
        if ($this->isCsrfTokenValid('delete'.$produitscommand->getId(), $request->request->get('_token'))) {
            $entityManager = $this->getDoctrine()->getManager();
            $entityManager->remove($produitscommand);
            $entityManager->flush();
        }

        return $this->redirectToRoute('produitscommand_index');
    }
}
