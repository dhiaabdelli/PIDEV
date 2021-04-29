<?php

use Twig\Environment;
use Twig\Error\LoaderError;
use Twig\Error\RuntimeError;
use Twig\Extension\SandboxExtension;
use Twig\Markup;
use Twig\Sandbox\SecurityError;
use Twig\Sandbox\SecurityNotAllowedTagError;
use Twig\Sandbox\SecurityNotAllowedFilterError;
use Twig\Sandbox\SecurityNotAllowedFunctionError;
use Twig\Source;
use Twig\Template;

/* programmealimentaire/index.html.twig */
class __TwigTemplate_99f82f031d975f35681777c2df9211dabcbffa6d0ffc58e9d0711c10d73d64e2 extends Template
{
    private $source;
    private $macros = [];

    public function __construct(Environment $env)
    {
        parent::__construct($env);

        $this->source = $this->getSourceContext();

        $this->blocks = [
            'title' => [$this, 'block_title'],
            'header' => [$this, 'block_header'],
            'breadcrumb' => [$this, 'block_breadcrumb'],
            'body' => [$this, 'block_body'],
        ];
    }

    protected function doGetParent(array $context)
    {
        // line 1
        return "back.html.twig";
    }

    protected function doDisplay(array $context, array $blocks = [])
    {
        $macros = $this->macros;
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e = $this->extensions["Symfony\\Bundle\\WebProfilerBundle\\Twig\\WebProfilerExtension"];
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e->enter($__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "template", "programmealimentaire/index.html.twig"));

        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02 = $this->extensions["Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension"];
        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02->enter($__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "template", "programmealimentaire/index.html.twig"));

        $this->parent = $this->loadTemplate("back.html.twig", "programmealimentaire/index.html.twig", 1);
        $this->parent->display($context, array_merge($this->blocks, $blocks));
        
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e->leave($__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e_prof);

        
        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02->leave($__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02_prof);

    }

    // line 3
    public function block_title($context, array $blocks = [])
    {
        $macros = $this->macros;
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e = $this->extensions["Symfony\\Bundle\\WebProfilerBundle\\Twig\\WebProfilerExtension"];
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e->enter($__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "block", "title"));

        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02 = $this->extensions["Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension"];
        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02->enter($__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "block", "title"));

        echo "Programmes Alimentaires";
        
        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02->leave($__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02_prof);

        
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e->leave($__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e_prof);

    }

    // line 5
    public function block_header($context, array $blocks = [])
    {
        $macros = $this->macros;
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e = $this->extensions["Symfony\\Bundle\\WebProfilerBundle\\Twig\\WebProfilerExtension"];
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e->enter($__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "block", "header"));

        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02 = $this->extensions["Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension"];
        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02->enter($__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "block", "header"));

        echo "Programmes Alimentaires";
        
        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02->leave($__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02_prof);

        
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e->leave($__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e_prof);

    }

    // line 7
    public function block_breadcrumb($context, array $blocks = [])
    {
        $macros = $this->macros;
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e = $this->extensions["Symfony\\Bundle\\WebProfilerBundle\\Twig\\WebProfilerExtension"];
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e->enter($__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "block", "breadcrumb"));

        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02 = $this->extensions["Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension"];
        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02->enter($__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "block", "breadcrumb"));

        echo "Programmes Alimentaires";
        
        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02->leave($__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02_prof);

        
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e->leave($__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e_prof);

    }

    // line 9
    public function block_body($context, array $blocks = [])
    {
        $macros = $this->macros;
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e = $this->extensions["Symfony\\Bundle\\WebProfilerBundle\\Twig\\WebProfilerExtension"];
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e->enter($__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "block", "body"));

        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02 = $this->extensions["Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension"];
        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02->enter($__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "block", "body"));

        // line 10
        echo "    <div class=\"box\">
        <div class=\"box-header with-border\">
            <h3 class=\"box-title\">Liste des Programmes Alimentaires</h3>
            <div class=\"box-tools\">
                <div class=\"input-group input-group-sm hidden-xs\" style=\"width: 150px;\">
                    <div class=\"input-group-btn\">
                        <a  href=\"";
        // line 16
        echo $this->extensions['Symfony\Bridge\Twig\Extension\RoutingExtension']->getPath("programmealimentaire_new");
        echo "\" class=\"btn bg-purple btn-flat\"><i class=\"fa fa-plus\"></i> Ajouter un Programme Alimentaire </a>
                    </div>
                </div>
            </div>
        </div>
        <div class=\"box-body\">

            <table class=\"table\" style=\"text-align: center\">
                <thead>
                <tr>
                    <th style=\"text-align: center\">Email Compte & N° Profile</th>
                    <th style=\"text-align: center\">Métabolisme de base (BMR)</th>
                    <th style=\"text-align: center\">Calories Requis</th>
                    <th style=\"text-align: center\">Lipides Requis</th>
                    <th style=\"text-align: center\">Glucides Requis</th>
                    <th style=\"text-align: center\">Proteines Requis</th>
                    <th style=\"text-align: center\">Actions</th>
                </tr>
                </thead>
                <tbody>
                ";
        // line 36
        $context['_parent'] = $context;
        $context['_seq'] = twig_ensure_traversable((isset($context["programmealimentaires"]) || array_key_exists("programmealimentaires", $context) ? $context["programmealimentaires"] : (function () { throw new RuntimeError('Variable "programmealimentaires" does not exist.', 36, $this->source); })()));
        $context['_iterated'] = false;
        foreach ($context['_seq'] as $context["_key"] => $context["programmealimentaire"]) {
            // line 37
            echo "                    <tr>
                        <td>";
            // line 38
            echo twig_escape_filter($this->env, twig_get_attribute($this->env, $this->source, twig_get_attribute($this->env, $this->source, twig_get_attribute($this->env, $this->source, $context["programmealimentaire"], "idprofile", [], "any", false, false, false, 38), "emailcompte", [], "any", false, false, false, 38), "email", [], "any", false, false, false, 38), "html", null, true);
            echo " : ";
            echo twig_escape_filter($this->env, twig_get_attribute($this->env, $this->source, twig_get_attribute($this->env, $this->source, $context["programmealimentaire"], "idprofile", [], "any", false, false, false, 38), "id", [], "any", false, false, false, 38), "html", null, true);
            echo "</td>
                        <td>";
            // line 39
            echo twig_escape_filter($this->env, twig_get_attribute($this->env, $this->source, $context["programmealimentaire"], "bmr", [], "any", false, false, false, 39), "html", null, true);
            echo "</td>
                        <td>";
            // line 40
            echo twig_escape_filter($this->env, twig_get_attribute($this->env, $this->source, $context["programmealimentaire"], "calrequis", [], "any", false, false, false, 40), "html", null, true);
            echo "</td>
                        <td>";
            // line 41
            echo twig_escape_filter($this->env, twig_get_attribute($this->env, $this->source, $context["programmealimentaire"], "fatsrequis", [], "any", false, false, false, 41), "html", null, true);
            echo "</td>
                        <td>";
            // line 42
            echo twig_escape_filter($this->env, twig_get_attribute($this->env, $this->source, $context["programmealimentaire"], "carbsrequis", [], "any", false, false, false, 42), "html", null, true);
            echo "</td>
                        <td>";
            // line 43
            echo twig_escape_filter($this->env, twig_get_attribute($this->env, $this->source, $context["programmealimentaire"], "proteinsrequis", [], "any", false, false, false, 43), "html", null, true);
            echo "</td>
                        <td>
                            <a href=\"";
            // line 45
            echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\RoutingExtension']->getPath("programmealimentaire_show", ["idprofile" => twig_get_attribute($this->env, $this->source, twig_get_attribute($this->env, $this->source, $context["programmealimentaire"], "idprofile", [], "any", false, false, false, 45), "id", [], "any", false, false, false, 45)]), "html", null, true);
            echo "\"><i class=\"fa fa-eye\"></i></a>
                            <a href=\"";
            // line 46
            echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\RoutingExtension']->getPath("programmealimentaire_edit", ["idprofile" => twig_get_attribute($this->env, $this->source, twig_get_attribute($this->env, $this->source, $context["programmealimentaire"], "idprofile", [], "any", false, false, false, 46), "id", [], "any", false, false, false, 46)]), "html", null, true);
            echo "\"><i class=\"fa fa-edit\"></i></a>
                        </td>
                    </tr>
                ";
            $context['_iterated'] = true;
        }
        if (!$context['_iterated']) {
            // line 50
            echo "                    <tr>
                        <td colspan=\"7\">Aucun résultat trouvé</td>
                    </tr>
                ";
        }
        $_parent = $context['_parent'];
        unset($context['_seq'], $context['_iterated'], $context['_key'], $context['programmealimentaire'], $context['_parent'], $context['loop']);
        $context = array_intersect_key($context, $_parent) + $_parent;
        // line 54
        echo "                </tbody>
            </table>
        </div>
    </div>
";
        
        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02->leave($__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02_prof);

        
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e->leave($__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e_prof);

    }

    public function getTemplateName()
    {
        return "programmealimentaire/index.html.twig";
    }

    public function isTraitable()
    {
        return false;
    }

    public function getDebugInfo()
    {
        return array (  216 => 54,  207 => 50,  198 => 46,  194 => 45,  189 => 43,  185 => 42,  181 => 41,  177 => 40,  173 => 39,  167 => 38,  164 => 37,  159 => 36,  136 => 16,  128 => 10,  118 => 9,  99 => 7,  80 => 5,  61 => 3,  38 => 1,);
    }

    public function getSourceContext()
    {
        return new Source("{% extends 'back.html.twig' %}

{% block title %}Programmes Alimentaires{% endblock %}

{% block header %}Programmes Alimentaires{% endblock %}

{% block breadcrumb %}Programmes Alimentaires{% endblock %}

{% block body %}
    <div class=\"box\">
        <div class=\"box-header with-border\">
            <h3 class=\"box-title\">Liste des Programmes Alimentaires</h3>
            <div class=\"box-tools\">
                <div class=\"input-group input-group-sm hidden-xs\" style=\"width: 150px;\">
                    <div class=\"input-group-btn\">
                        <a  href=\"{{ path('programmealimentaire_new') }}\" class=\"btn bg-purple btn-flat\"><i class=\"fa fa-plus\"></i> Ajouter un Programme Alimentaire </a>
                    </div>
                </div>
            </div>
        </div>
        <div class=\"box-body\">

            <table class=\"table\" style=\"text-align: center\">
                <thead>
                <tr>
                    <th style=\"text-align: center\">Email Compte & N° Profile</th>
                    <th style=\"text-align: center\">Métabolisme de base (BMR)</th>
                    <th style=\"text-align: center\">Calories Requis</th>
                    <th style=\"text-align: center\">Lipides Requis</th>
                    <th style=\"text-align: center\">Glucides Requis</th>
                    <th style=\"text-align: center\">Proteines Requis</th>
                    <th style=\"text-align: center\">Actions</th>
                </tr>
                </thead>
                <tbody>
                {% for programmealimentaire in programmealimentaires %}
                    <tr>
                        <td>{{ programmealimentaire.idprofile.emailcompte.email }} : {{ programmealimentaire.idprofile.id }}</td>
                        <td>{{ programmealimentaire.bmr }}</td>
                        <td>{{ programmealimentaire.calrequis }}</td>
                        <td>{{ programmealimentaire.fatsrequis }}</td>
                        <td>{{ programmealimentaire.carbsrequis }}</td>
                        <td>{{ programmealimentaire.proteinsrequis }}</td>
                        <td>
                            <a href=\"{{ path('programmealimentaire_show', {'idprofile': programmealimentaire.idprofile.id }) }}\"><i class=\"fa fa-eye\"></i></a>
                            <a href=\"{{ path('programmealimentaire_edit', {'idprofile': programmealimentaire.idprofile.id }) }}\"><i class=\"fa fa-edit\"></i></a>
                        </td>
                    </tr>
                {% else %}
                    <tr>
                        <td colspan=\"7\">Aucun résultat trouvé</td>
                    </tr>
                {% endfor %}
                </tbody>
            </table>
        </div>
    </div>
{% endblock %}

", "programmealimentaire/index.html.twig", "C:\\wamp64\\www\\pidev\\templates\\programmealimentaire\\index.html.twig");
    }
}
