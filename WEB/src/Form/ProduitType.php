<?php

namespace App\Form;


use App\Entity\Produit;
use App\Entity\Categorie;
use Symfony\Component\Form\AbstractType;
use Symfony\Component\Form\Extension\Core\Type\TextType;
use Symfony\Component\Form\FormBuilderInterface;
use Symfony\Component\OptionsResolver\OptionsResolver;
use Symfony\Component\Validator\Constraints\AbstractComparison;
use Symfony\Component\Validator\Constraints\Length;
use Symfony\Component\Validator\Constraints\Regex;
use Symfony\Component\Validator\Constraints\GreaterThan;
use Symfony\Component\Validator\Constraints\GreaterThanOrEqual;
use Symfony\Bridge\Doctrine\Form\Type\EntityType;

class ProduitType extends AbstractType
{
    public function buildForm(FormBuilderInterface $builder, array $options)
    {
        $builder
            ->add('libelle', TextType::class, [
                'constraints' => new Length(['min' => 5]),
                'constraints'      => new Regex(array(
                    'pattern'   => '/^[a-zA-z ]+$/',
                    'match'     => true,
                    //'message'   => 'Postleitzahl ist nicht numerisch.'
                )),
            ])
            ->add('prix', TextType::class, [
                'constraints'      => new GreaterThan(array(
                    'value' => 0,
                )),
            ])
            ->add('description', TextType::class, [
                'constraints' => new Length(['min' => 10]),
                'constraints'      => new Regex(array(
                    'pattern'   => '/^[a-zA-z ]+$/',
                    'match'     => true,
                    //'message'   => 'Postleitzahl ist nicht numerisch.'
                )),
            ])
            ->add('qt', TextType::class, [
                'constraints'      => new GreaterThanOrEqual(array(
                    'value' => 0,
                )),
            ])
            ->add('img')
            ->add('idcategorie', EntityType::class, [
                'class' => Categorie::class,
                'choice_label' => 'nom',
            ])
        ;
    }

    public function configureOptions(OptionsResolver $resolver)
    {
        $resolver->setDefaults([
            'data_class' => Produit::class,
        ]);
    }
}
