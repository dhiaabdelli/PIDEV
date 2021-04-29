<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Exerciceassocie
 *
 * @ORM\Table(name="exerciceassocie", uniqueConstraints={@ORM\UniqueConstraint(name="libelleExercice", columns={"libelleExercice"})})
 * @ORM\Entity
 */
class Exerciceassocie
{
    /**
     * @var int
     *
     * @ORM\Column(name="idExAssocier", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idexassocier;

    /**
     * @var int
     *
     * @ORM\Column(name="idProfile", type="integer", nullable=false)
     */
    private $idprofile;

    /**
     * @var string
     *
     * @ORM\Column(name="libelleExercice", type="string", length=30, nullable=false)
     */
    private $libelleexercice;

    /**
     * @var int|null
     *
     * @ORM\Column(name="nbSeries", type="integer", nullable=true)
     */
    private $nbseries;

    /**
     * @var int|null
     *
     * @ORM\Column(name="nbRepetitions", type="integer", nullable=true)
     */
    private $nbrepetitions;

    /**
     * @var int|null
     *
     * @ORM\Column(name="jour", type="integer", nullable=true)
     */
    private $jour;

    public function getIdexassocier(): ?int
    {
        return $this->idexassocier;
    }

    public function getIdprofile(): ?int
    {
        return $this->idprofile;
    }

    public function setIdprofile(int $idprofile): self
    {
        $this->idprofile = $idprofile;

        return $this;
    }

    public function getLibelleexercice(): ?string
    {
        return $this->libelleexercice;
    }

    public function setLibelleexercice(string $libelleexercice): self
    {
        $this->libelleexercice = $libelleexercice;

        return $this;
    }

    public function getNbseries(): ?int
    {
        return $this->nbseries;
    }

    public function setNbseries(?int $nbseries): self
    {
        $this->nbseries = $nbseries;

        return $this;
    }

    public function getNbrepetitions(): ?int
    {
        return $this->nbrepetitions;
    }

    public function setNbrepetitions(?int $nbrepetitions): self
    {
        $this->nbrepetitions = $nbrepetitions;

        return $this;
    }

    public function getJour(): ?int
    {
        return $this->jour;
    }

    public function setJour(?int $jour): self
    {
        $this->jour = $jour;

        return $this;
    }


}
