<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Profile
 *
 * @ORM\Table(name="profile", indexes={@ORM\Index(name="fk_idemail", columns={"emailCompte"})})
 * @ORM\Entity
 */
class Profile
{
    /**
     * @var string
     *
     * @ORM\Column(name="id", type="string", length=20, nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $id;

    /**
     * @var int|null
     *
     * @ORM\Column(name="sexe", type="integer", nullable=true)
     */
    private $sexe;

    /**
     * @var int|null
     *
     * @ORM\Column(name="age", type="integer", nullable=true)
     */
    private $age;

    /**
     * @var float|null
     *
     * @ORM\Column(name="poids", type="float", precision=10, scale=0, nullable=true)
     */
    private $poids;

    /**
     * @var float|null
     *
     * @ORM\Column(name="taille", type="float", precision=10, scale=0, nullable=true)
     */
    private $taille;

    /**
     * @var int|null
     *
     * @ORM\Column(name="objectif", type="integer", nullable=true)
     */
    private $objectif;

    /**
     * @var int|null
     *
     * @ORM\Column(name="nbRepas", type="integer", nullable=true)
     */
    private $nbrepas;

    /**
     * @var \Compte
     *
     * @ORM\ManyToOne(targetEntity="Compte")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="emailCompte", referencedColumnName="email")
     * })
     */
    private $emailcompte;

    public function getId(): ?string
    {
        return $this->id;
    }

    public function getSexe(): ?int
    {
        return $this->sexe;
    }

    public function setSexe(?int $sexe): self
    {
        $this->sexe = $sexe;

        return $this;
    }

    public function getAge(): ?int
    {
        return $this->age;
    }

    public function setAge(?int $age): self
    {
        $this->age = $age;

        return $this;
    }

    public function getPoids(): ?float
    {
        return $this->poids;
    }

    public function setPoids(?float $poids): self
    {
        $this->poids = $poids;

        return $this;
    }

    public function getTaille(): ?float
    {
        return $this->taille;
    }

    public function setTaille(?float $taille): self
    {
        $this->taille = $taille;

        return $this;
    }

    public function getObjectif(): ?int
    {
        return $this->objectif;
    }

    public function setObjectif(?int $objectif): self
    {
        $this->objectif = $objectif;

        return $this;
    }

    public function getNbrepas(): ?int
    {
        return $this->nbrepas;
    }

    public function setNbrepas(?int $nbrepas): self
    {
        $this->nbrepas = $nbrepas;

        return $this;
    }

    public function getEmailcompte(): ?Compte
    {
        return $this->emailcompte;
    }

    public function setEmailcompte(?Compte $emailcompte): self
    {
        $this->emailcompte = $emailcompte;

        return $this;
    }


}
