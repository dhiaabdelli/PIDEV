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


}
