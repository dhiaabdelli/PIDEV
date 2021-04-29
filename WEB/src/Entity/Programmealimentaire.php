<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Programmealimentaire
 *
 * @ORM\Table(name="programmealimentaire")
 * @ORM\Entity
 */
class Programmealimentaire
{
    /**
     * @var string
     *
     * @ORM\Column(name="idProfile", type="string", length=20, nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idprofile;

    /**
     * @var int|null
     *
     * @ORM\Column(name="bmr", type="integer", nullable=true)
     */
    private $bmr;

    /**
     * @var int|null
     *
     * @ORM\Column(name="calRequis", type="integer", nullable=true)
     */
    private $calrequis;

    /**
     * @var int|null
     *
     * @ORM\Column(name="fatsRequis", type="integer", nullable=true)
     */
    private $fatsrequis;

    /**
     * @var int|null
     *
     * @ORM\Column(name="carbsRequis", type="integer", nullable=true)
     */
    private $carbsrequis;

    /**
     * @var int|null
     *
     * @ORM\Column(name="proteinsRequis", type="integer", nullable=true)
     */
    private $proteinsrequis;

    public function getIdprofile(): ?string
    {
        return $this->idprofile;
    }

    public function getBmr(): ?int
    {
        return $this->bmr;
    }

    public function setBmr(?int $bmr): self
    {
        $this->bmr = $bmr;

        return $this;
    }

    public function getCalrequis(): ?int
    {
        return $this->calrequis;
    }

    public function setCalrequis(?int $calrequis): self
    {
        $this->calrequis = $calrequis;

        return $this;
    }

    public function getFatsrequis(): ?int
    {
        return $this->fatsrequis;
    }

    public function setFatsrequis(?int $fatsrequis): self
    {
        $this->fatsrequis = $fatsrequis;

        return $this;
    }

    public function getCarbsrequis(): ?int
    {
        return $this->carbsrequis;
    }

    public function setCarbsrequis(?int $carbsrequis): self
    {
        $this->carbsrequis = $carbsrequis;

        return $this;
    }

    public function getProteinsrequis(): ?int
    {
        return $this->proteinsrequis;
    }

    public function setProteinsrequis(?int $proteinsrequis): self
    {
        $this->proteinsrequis = $proteinsrequis;

        return $this;
    }


}
