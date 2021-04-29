<?php

namespace App\Repository;

use App\Entity\Alimentassocie;
use Doctrine\Bundle\DoctrineBundle\Repository\ServiceEntityRepository;
use Doctrine\Persistence\ManagerRegistry;

/**
 * @method Alimentassocie|null find($id, $lockMode = null, $lockVersion = null)
 * @method Alimentassocie|null findOneBy(array $criteria, array $orderBy = null)
 * @method Alimentassocie[]    findAll()
 * @method Alimentassocie[]    findBy(array $criteria, array $orderBy = null, $limit = null, $offset = null)
 */
class AlimentassocieRepository extends ServiceEntityRepository
{
    public function __construct(ManagerRegistry $registry)
    {
        parent::__construct($registry, Alimentassocie::class);
    }
}