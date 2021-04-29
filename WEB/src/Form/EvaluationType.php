<?php

namespace App\Form;

use App\Entity\Evaluation;
use App\Entity\Produit;
use App\Entity\Compte;
use Symfony\Component\Form\AbstractType;
use Symfony\Component\Form\FormBuilderInterface;
use Symfony\Component\OptionsResolver\OptionsResolver;
use Symfony\Bridge\Doctrine\Form\Type\EntityType;
class EvaluationType extends AbstractType
{
    public function buildForm(FormBuilderInterface $builder, array $options)
    {
        $builder
            ->add('idUser', EntityType::class, [
                'class' => Compte::class,
                'choice_label' => 'email',
            ])
            ->add('note')
            ->add('idProduit', EntityType::class, [
                'class' => Produit::class,
                'choice_label' => 'libelle',
            ])

        ;
    }

    public function configureOptions(OptionsResolver $resolver)
    {
        $resolver->setDefaults([
            'data_class' => Evaluation::class,
        ]);
    }
}
