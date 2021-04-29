<?php

namespace App\Repository;

use App\Entity\Programmealimentaire;
use Doctrine\Bundle\DoctrineBundle\Repository\ServiceEntityRepository;
use Doctrine\Persistence\ManagerRegistry;

/**
 * @method Programmealimentaire|null find($id, $lockMode = null, $lockVersion = null)
 * @method Programmealimentaire|null findOneBy(array $criteria, array $orderBy = null)
 * @method Programmealimentaire[]    findAll()
 * @method Programmealimentaire[]    findBy(array $criteria, array $orderBy = null, $limit = null, $offset = null)
 */
class ProgrammealimentaireRepository extends ServiceEntityRepository
{
    public function __construct(ManagerRegistry $registry)
    {
        parent::__construct($registry, Programmealimentaire::class);
    }
}
