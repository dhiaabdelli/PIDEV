<?php

namespace App\Form;

use App\Entity\Programmealimentaire;
use Symfony\Component\Form\AbstractType;
use Symfony\Component\Form\FormBuilderInterface;
use Symfony\Component\OptionsResolver\OptionsResolver;

class ProgrammealimentaireType extends AbstractType
{
    public function buildForm(FormBuilderInterface $builder, array $options)
    {
        $builder
            ->add('bmr')
            ->add('calrequis')
            ->add('fatsrequis')
            ->add('carbsrequis')
            ->add('proteinsrequis')
        ;
    }

    public function configureOptions(OptionsResolver $resolver)
    {
        $resolver->setDefaults([
            'data_class' => Programmealimentaire::class,
        ]);
    }
}
