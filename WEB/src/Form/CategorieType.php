<?php

namespace App\Form;

use App\Entity\Categorie;
use Symfony\Component\Form\AbstractType;
use Symfony\Component\Form\FormBuilderInterface;
use Symfony\Component\OptionsResolver\OptionsResolver;
use Symfony\Component\Form\Extension\Core\Type\TextType;
use Symfony\Component\Validator\Constraints\Length;
use Symfony\Component\Validator\Constraints\Regex;

class CategorieType extends AbstractType
{
    public function buildForm(FormBuilderInterface $builder, array $options)
    {
        $builder
            ->add('nom', TextType::class, [
                'constraints' => new Length(['min' => 5]),
                'constraints'      => new Regex(array(
                    'pattern'   => '/^[a-zA-z ]+$/',
                    'match'     => true,
                    //'message'   => 'Postleitzahl ist nicht numerisch.'
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
        ;
    }

    public function configureOptions(OptionsResolver $resolver)
    {
        $resolver->setDefaults([
            'data_class' => Categorie::class,
        ]);
    }
}
