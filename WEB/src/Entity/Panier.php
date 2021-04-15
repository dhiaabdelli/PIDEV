<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Panier
 *
 * @ORM\Table(name="panier")
 * @ORM\Entity
 */
class Panier
{
    /**
     * @var string
     *
     * @ORM\Column(name="idproduit", type="string", length=20, nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="NONE")
     */
    private $idproduit;

    /**
     * @var string
     *
     * @ORM\Column(name="email", type="string", length=80, nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="NONE")
     */
    private $email;

    /**
     * @var int|null
     *
     * @ORM\Column(name="qt", type="integer", nullable=true)
     */
    private $qt;


    public function getIdproduit()
    {
        return $this->idproduit;
    }

    public function setIdproduit($idproduit)
    {
        $this->idproduit = $idproduit;
    }


    public function getEmail()
    {
        return $this->email;
    }


    public function setEmail($email)
    {
        $this->email = $email;
    }

    public function getQt()
    {
        return $this->qt;
    }


    public function setQt($qt)
    {
        $this->qt = $qt;
    }


}
