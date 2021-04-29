<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Alimentassocie
 *
 * @ORM\Table(name="alimentassocie")
 * @ORM\Entity
 */
class Alimentassocie
{
    /**
     * @var string
     *
     * @ORM\Column(name="idAliment", type="string", length=20, nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="NONE")
     */
    private $idaliment;

    /**
     * @var string
     *
     * @ORM\Column(name="idProfile", type="string", length=20, nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="NONE")
     */
    private $idprofile;

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

    public function getIdaliment(): ?string
    {
        return $this->idaliment;
    }

    public function getIdprofile(): ?string
    {
        return $this->idprofile;
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


}
