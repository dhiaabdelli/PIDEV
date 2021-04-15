<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Livraison
 *
 * @ORM\Table(name="livraison")
 * @ORM\Entity
 */
class Livraison
{
    /**
     * @var int
     *
     * @ORM\Column(name="idLivraison", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idlivraison;

    /**
     * @var int
     *
     * @ORM\Column(name="reference", type="integer", nullable=false)
     */
    private $reference;

    /**
     * @var string
     *
     * @ORM\Column(name="dateLivraison", type="string", length=20, nullable=false)
     */
    private $datelivraison;

    /**
     * @var string|null
     *
     * @ORM\Column(name="nomLivreur", type="string", length=20, nullable=true)
     */
    private $nomlivreur;

    /**
     * @var string|null
     *
     * @ORM\Column(name="etat", type="string", length=10, nullable=true)
     */
    private $etat;

    /**
     * @var string|null
     *
     * @ORM\Column(name="nomClient", type="string", length=30, nullable=true)
     */
    private $nomclient;


}
