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
     * @var string
     *
     * @ORM\Column(name="id", type="string", length=20, nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $id;

    /**
     * @return string
     */
    public function getId(): string
    {
        return $this->id;
    }

    /**
     * @param string $id
     */
    public function setId(string $id): void
    {
        $this->id = $id;
    }

    /**
     * @return string|null
     */
    public function getNom(): ?string
    {
        return $this->nom;
    }

    /**
     * @param string|null $nom
     */
    public function setNom(?string $nom): void
    {
        $this->nom = $nom;
    }

    /**
     * @return int|null
     */
    public function getFats(): ?int
    {
        return $this->fats;
    }

    /**
     * @param int|null $fats
     */
    public function setFats(?int $fats): void
    {
        $this->fats = $fats;
    }

    /**
     * @return int|null
     */
    public function getCarbs(): ?int
    {
        return $this->carbs;
    }

    /**
     * @param int|null $carbs
     */
    public function setCarbs(?int $carbs): void
    {
        $this->carbs = $carbs;
    }

    /**
     * @return int|null
     */
    public function getProteins(): ?int
    {
        return $this->proteins;
    }

    /**
     * @param int|null $proteins
     */
    public function setProteins(?int $proteins): void
    {
        $this->proteins = $proteins;
    }

    /**
     * @return int|null
     */
    public function getCalories(): ?int
    {
        return $this->calories;
    }

    /**
     * @param int|null $calories
     */
    public function setCalories(?int $calories): void
    {
        $this->calories = $calories;
    }

    /**
     * @return int|null
     */
    public function getType(): ?int
    {
        return $this->type;
    }

    /**
     * @param int|null $type
     */
    public function setType(?int $type): void
    {
        $this->type = $type;
    }

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


}
