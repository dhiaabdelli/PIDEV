<?php

namespace App\Form;

use App\Entity\Aliment;
use Symfony\Component\Form\AbstractType;
use Symfony\Component\Form\Extension\Core\Type\TextType;
use Symfony\Component\Form\Extension\Core\Type\IntegerType;
use Symfony\Component\Form\FormBuilderInterface;
use Symfony\Component\OptionsResolver\OptionsResolver;
use Symfony\Component\Validator\Constraints\GreaterThanOrEqual;
use Symfony\Component\Validator\Constraints\Length;
use Symfony\Component\Validator\Constraints\Regex;

class AlimentType extends AbstractType
{
    public function buildForm(FormBuilderInterface $builder, array $options)
    {
        $builder
            ->add('nom', TextType::class, [
                    'label' => 'Nom Aliment',
                    'constraints' => [new Length(['min' => 3]),
                    new Length(['max' => 30]),
                    new Regex(array(
                        'pattern'   => '/^[a-zA-z ]+$/',
                        'match'     => true,
                    )
                )
                ]
            ])
            ->add('fats', IntegerType::class, [
                'label' => 'Lipides',
                'constraints'      => new GreaterThanOrEqual(array(
                    'value' => 0,
                )),
            ])
            ->add('carbs', IntegerType::class, [
                'label' => 'Glucides',
                'constraints'      => new GreaterThanOrEqual(array(
                    'value' => 0,
                )),
            ])
            ->add('proteins', IntegerType::class, [
                'label' => 'Proteines',
                'constraints'      => new GreaterThanOrEqual(array(
                    'value' => 0,
                )),
            ])
            ->add('calories', IntegerType::class, [
                'constraints'      => new GreaterThanOrEqual(array(
                    'value' => 0,
                )),
            ])
        ;
    }

    public function configureOptions(OptionsResolver $resolver)
    {
        $resolver->setDefaults([
            'data_class' => Aliment::class,
        ]);
    }
}
