<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Produit
 *
 * @ORM\Table(name="produit", indexes={@ORM\Index(name="fk_idcatedel", columns={"idCategorie"})})
 * @ORM\Entity
 */
class Produit
{
    /**
     * @var int
     *
     * @ORM\Column(name="id", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $id;


    /**
     * @var string|null
     *
     * @ORM\Column(name="libelle", type="string", length=20, nullable=true)
     */
    private $libelle;

    /**
     * @var float|null
     *
     * @ORM\Column(name="prix", type="float", precision=10, scale=0, nullable=true)
     */
    private $prix;

    /**
     * @var string|null
     *
     * @ORM\Column(name="description", type="string", length=20, nullable=true)
     */
    private $description;

    /**
     * @var int
     *
     * @ORM\Column(name="qt", type="integer", nullable=false)
     */
    private $qt;

    /**
     * @var string|null
     *
     * @ORM\Column(name="img", type="string", length=255, nullable=true)
     */
    private $img;

    /**
     * @var int
     *
     * @ORM\Column(name="idCategorie", type="integer", nullable=false)
     */
    private $idcategorie;

    public function getId()
    {
        return $this->id;
    }

    public function setId($id)
    {
        $this->id = $id;
    }

    public function getLibelle()
    {
        return $this->libelle;
    }


    public function setLibelle($libelle)
    {
        $this->libelle = $libelle;
    }


    public function getPrix()
    {
        return $this->prix;
    }


    public function setPrix($prix)
    {
        $this->prix = $prix;
    }


    public function getDescription()
    {
        return $this->description;
    }

    public function setDescription($description)
    {
        $this->description = $description;
    }

    public function getQt()
    {
        return $this->qt;
    }


    public function setQt($qt)
    {
        $this->qt = $qt;
    }

    public function getImg()
    {
        return $this->img;
    }

    public function setImg($img)
    {
        $this->img = $img;
    }

    public function getIdcategorie()
    {
        return $this->idcategorie;
    }

    public function setIdcategorie($idcategorie)
    {
        $this->idcategorie = $idcategorie;
    }
}
