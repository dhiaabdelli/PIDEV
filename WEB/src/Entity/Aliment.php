<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Aliment
 *
 * @ORM\Table(name="aliment")
 * @ORM\Entity
 */
class Aliment
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
     * @ORM\Column(name="nom", type="string", length=20, nullable=true)
     */
    private $nom;

    /**
     * @var int|null
     *
     * @ORM\Column(name="fats", type="integer", nullable=true)
     */
    private $fats;

    /**
     * @var int|null
     *
     * @ORM\Column(name="carbs", type="integer", nullable=true)
     */
    private $carbs;

    /**
     * @var int|null
     *
     * @ORM\Column(name="proteins", type="integer", nullable=true)
     */
    private $proteins;

    /**
     * @var int|null
     *
     * @ORM\Column(name="calories", type="integer", nullable=true)
     */
    private $calories;

    /**
     * @var int|null
     *
     * @ORM\Column(name="type", type="integer", nullable=true)
     */
    private $type;

    public function getId(): ?int
    {
        return $this->id;
    }

    public function getNom(): ?string
    {
        return $this->nom;
    }

    public function setNom(?string $nom): self
    {
        $this->nom = $nom;

        return $this;
    }

    public function getFats(): ?int
    {
        return $this->fats;
    }

    public function setFats(?int $fats): self
    {
        $this->fats = $fats;

        return $this;
    }

    public function getCarbs(): ?int
    {
        return $this->carbs;
    }

    public function setCarbs(?int $carbs): self
    {
        $this->carbs = $carbs;

        return $this;
    }

    public function getProteins(): ?int
    {
        return $this->proteins;
    }

    public function setProteins(?int $proteins): self
    {
        $this->proteins = $proteins;

        return $this;
    }

    public function getCalories(): ?int
    {
        return $this->calories;
    }

    public function setCalories(?int $calories): self
    {
        $this->calories = $calories;

        return $this;
    }

    public function getType(): ?int
    {
        return $this->type;
    }

    public function setType(?int $type): self
    {
        $this->type = $type;

        return $this;
    }

    public function __toString()
    {
        return strval($this->id);
    }

}
