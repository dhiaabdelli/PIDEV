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


}
