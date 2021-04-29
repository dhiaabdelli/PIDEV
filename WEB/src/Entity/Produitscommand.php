<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Produitscommand
 *
 * @ORM\Table(name="produitscommand")
 * @ORM\Entity
 */
class Produitscommand
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
     * @var int
     *
     * @ORM\Column(name="idproduit", type="integer", nullable=false)
     */
    private $idproduit;

    /**
     * @var int
     *
     * @ORM\Column(name="qt", type="integer", nullable=false)
     */
    private $qt;

    public function getId(): ?int
    {
        return $this->id;
    }

    public function getIdproduit(): ?int
    {
        return $this->idproduit;
    }

    public function setIdproduit(int $idproduit): self
    {
        $this->idproduit = $idproduit;

        return $this;
    }

    public function getQt(): ?int
    {
        return $this->qt;
    }

    public function setQt(int $qt): self
    {
        $this->qt = $qt;

        return $this;
    }


}
