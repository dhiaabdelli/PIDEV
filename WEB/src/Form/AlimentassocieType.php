<?php

namespace App\Form;

use App\Entity\Alimentassocie;
use Symfony\Component\Form\AbstractType;
use Symfony\Component\Form\Extension\Core\Type\ChoiceType;
use Symfony\Component\Form\Extension\Core\Type\IntegerType;
use Symfony\Component\Form\FormBuilderInterface;
use Symfony\Component\OptionsResolver\OptionsResolver;
use App\Entity\Aliment;
use App\Entity\Profile;
use Symfony\Bridge\Doctrine\Form\Type\EntityType;
use Symfony\Component\Validator\Constraints\GreaterThanOrEqual;

class AlimentassocieType extends AbstractType
{
    public function buildForm(FormBuilderInterface $builder, array $options)
    {
        $builder
            ->add('idaliment', EntityType::class, [
                'label' => 'Nom de l\'Aliment',
                'class' => Aliment::class,
                'choice_label' => 'nom',
            ])
            ->add('idprofile', EntityType::class, [
                'label' => 'Email Compte & N° Profile',
                'class' => Profile::class,
                'choice_label' =>  function (Profile $profile) {
                    return $profile->getEmailcompte()->getEmail() . ' : ' . $profile->getid();
                },
            ])
            ->add('qte', IntegerType::class, [
                'label' => 'Quantitée (Grammes)',
                'constraints'      => new GreaterThanOrEqual(array(
                    'value' => 0,
                )),
            ])
            ->add('repas', ChoiceType::class, [
                'label' => 'N° Repas',
                'choices' => [
                    '1' => 1,
                    '2' => 1,
                    '3' => 3,
                    '4' => 4,
                    '5' => 5,
                ],
            ])
        ;
    }

    public function configureOptions(OptionsResolver $resolver)
    {
        $resolver->setDefaults([
            'data_class' => Alimentassocie::class,
        ]);
    }
}
