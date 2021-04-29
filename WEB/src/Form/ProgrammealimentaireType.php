<?php

namespace App\Form;

use App\Entity\Profile;
use App\Entity\Programmealimentaire;
use Symfony\Bridge\Doctrine\Form\Type\EntityType;
use Symfony\Component\Form\AbstractType;
use Symfony\Component\Form\Extension\Core\Type\IntegerType;
use Symfony\Component\Form\FormBuilderInterface;
use Symfony\Component\OptionsResolver\OptionsResolver;
use Symfony\Component\Validator\Constraints\GreaterThanOrEqual;

class ProgrammealimentaireType extends AbstractType
{
    public function buildForm(FormBuilderInterface $builder, array $options)
    {
        $builder
            ->add('idprofile', EntityType::class, [
                'label' => 'Email Compte & N° Profile',
                'class' => Profile::class,
                'choice_label' =>  function (Profile $profile) {
                    return $profile->getEmailcompte()->getEmail() . ' : ' . $profile->getid();
                },
            ])
            ->add('bmr', IntegerType::class, [
                'label' => 'Métabolisme de base (BMR)',
                'constraints'      => new GreaterThanOrEqual(array(
                    'value' => 0,
                )),
            ])
            ->add('calrequis', IntegerType::class, [
                'label' => 'Calories Requis',
                'constraints'      => new GreaterThanOrEqual(array(
                    'value' => 0,
                )),
            ])
            ->add('fatsrequis', IntegerType::class, [
                'label' => 'Lipides Requis',
                'constraints'      => new GreaterThanOrEqual(array(
                    'value' => 0,
                )),
            ])
            ->add('carbsrequis', IntegerType::class, [
                'label' => 'Glucides Requis',
                'constraints'      => new GreaterThanOrEqual(array(
                    'value' => 0,
                )),
            ])
            ->add('proteinsrequis', IntegerType::class, [
                'label' => 'Proteines Requis',
                'constraints'      => new GreaterThanOrEqual(array(
                    'value' => 0,
                )),
            ])
        ;
    }

    public function configureOptions(OptionsResolver $resolver)
    {
        $resolver->setDefaults([
            'data_class' => Programmealimentaire::class,
        ]);
    }
}
