<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Alimentassocie
 *
 * @ORM\Table(name="alimentassocie", indexes={@ORM\Index(name="fk_idaliment", columns={"idAliment"}), @ORM\Index(name="fk_idprofile", columns={"idProfile"})})
 * @ORM\Entity
 */
class Alimentassocie
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
     * @var int|null
     *
     * @ORM\Column(name="qte", type="integer", nullable=true)
     */
    private $qte;

    /**
     * @var int
     *
     * @ORM\Column(name="repas", type="integer", nullable=false)
     */
    private $repas;

    /**
     * @var \Aliment
     *
     * @ORM\ManyToOne(targetEntity="Aliment", fetch="EAGER")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="idAliment", referencedColumnName="id")
     * })
     */
    private $idaliment;

    /**
     * @var \Profile
     *
     * @ORM\ManyToOne(targetEntity="Profile", fetch="EAGER")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="idProfile", referencedColumnName="id")
     * })
     */
    private $idprofile;


    public function getId(): ?int
    {
        return $this->id;
    }

    public function getQte(): ?int
    {
        return $this->qte;
    }

    public function setQte(?int $qte): self
    {
        $this->qte = $qte;

        return $this;
    }

    public function getRepas(): ?int
    {
        return $this->repas;
    }

    public function setRepas(int $repas): self
    {
        $this->repas = $repas;

        return $this;
    }

    public function getIdaliment(): ?Aliment
    {
        return $this->idaliment;
    }

    public function setIdaliment(?Aliment $idaliment): self
    {
        $this->idaliment = $idaliment;

        return $this;
    }

    public function getIdprofile(): ?Profile
    {
        return $this->idprofile;
    }

    public function setIdprofile(?Profile $idprofile): self
    {
        $this->idprofile = $idprofile;

        return $this;
    }


}
