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


}
