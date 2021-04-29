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

    public function getIdproduit(): ?string
    {
        return $this->idproduit;
    }

    public function getEmail(): ?string
    {
        return $this->email;
    }

    public function getQt(): ?int
    {
        return $this->qt;
    }

    public function setQt(?int $qt): self
    {
        $this->qt = $qt;

        return $this;
    }


}
