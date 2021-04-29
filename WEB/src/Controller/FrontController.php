<?php

namespace App\Controller;

use App\Entity\Produit;
use App\Entity\Profile;
use App\Entity\Categorie;
use App\Entity\Programmealimentaire;
use App\Entity\Alimentassocie;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;

class FrontController extends AbstractController
{
    private $email = "habib.majoul@hotmail.fr";
    private  $idProfile = 1;
    /**
     * @Route("/shop", name="shop")
     */
    public function index(): Response
    {
        $produits = $this->getDoctrine()
            ->getRepository(Produit::class)
            ->findAll();
        $categories = $this->getDoctrine()
            ->getRepository(Categorie::class)
            ->findAll();
        return $this->render('front/shop/shop.html.twig', [
            'controller_name' => 'FrontController',
            'produits' => $produits,
            'categories' => $categories,
        ]);
    }

    /**
     * @Route("/progalim", name="progalim")
     */
    public function progalim(): Response
    {
        $progalims = $this->getDoctrine()
            ->getRepository(Programmealimentaire::class)
            ->find($this->idProfile);
        $alimentassoc = $this->getDoctrine()
            ->getRepository(Alimentassocie::class)
            ->findBy(array('idprofile' => $this->idProfile));
        $prf = $this->getDoctrine()
            ->getRepository(Profile::class)
            ->find($this->idProfile);
        return $this->render('front/progalim/index.html.twig', [
            'progalims' => $progalims,
            'alimentassoc' => $alimentassoc,
            'prf' => $prf,
        ]);
    }
    
    /**
     * @Route("/shop/{id}", name="shop_showcat", methods={"GET"})
     */
    public function show(Categorie $categorie): Response
    {
        $produits = $this->getDoctrine()
            ->getRepository(Produit::class)
            ->findBy(['idcategorie' => $categorie->getId()]);
        $categories = $this->getDoctrine()
            ->getRepository(Categorie::class)
            ->findAll();
        return $this->render('front/shop/shop.html.twig', [
            'produits' => $produits,
            'categories' => $categories,
        ]);
    }
}
