<?php

namespace App\Form;

use App\Entity\Exerciceassocie;
use Symfony\Component\Form\AbstractType;
use Symfony\Component\Form\FormBuilderInterface;
use Symfony\Component\OptionsResolver\OptionsResolver;

class ExerciceassocieType extends AbstractType
{
    public function buildForm(FormBuilderInterface $builder, array $options)
    {
        $builder
            ->add('idprofile')
            ->add('libelleexercice')
            ->add('nbseries')
            ->add('nbrepetitions')
            ->add('jour')
        ;
    }

    public function configureOptions(OptionsResolver $resolver)
    {
        $resolver->setDefaults([
            'data_class' => Exerciceassocie::class,
        ]);
    }
}
