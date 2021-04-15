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

/* exerciceassocie/show.html.twig */
class __TwigTemplate_10ee1976005a541469b41291feb593bcfcfde0fa03bbdd386ba6ef8f4cda0518 extends Template
{
    private $source;
    private $macros = [];

    public function __construct(Environment $env)
    {
        parent::__construct($env);

        $this->source = $this->getSourceContext();

        $this->blocks = [
            'title' => [$this, 'block_title'],
            'body' => [$this, 'block_body'],
        ];
    }

    protected function doGetParent(array $context)
    {
        // line 1
        return "base.html.twig";
    }

    protected function doDisplay(array $context, array $blocks = [])
    {
        $macros = $this->macros;
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e = $this->extensions["Symfony\\Bundle\\WebProfilerBundle\\Twig\\WebProfilerExtension"];
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e->enter($__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "template", "exerciceassocie/show.html.twig"));

        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02 = $this->extensions["Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension"];
        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02->enter($__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "template", "exerciceassocie/show.html.twig"));

        $this->parent = $this->loadTemplate("base.html.twig", "exerciceassocie/show.html.twig", 1);
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

        echo "Exerciceassocie";
        
        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02->leave($__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02_prof);

        
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e->leave($__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e_prof);

    }

    // line 5
    public function block_body($context, array $blocks = [])
    {
        $macros = $this->macros;
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e = $this->extensions["Symfony\\Bundle\\WebProfilerBundle\\Twig\\WebProfilerExtension"];
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e->enter($__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "block", "body"));

        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02 = $this->extensions["Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension"];
        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02->enter($__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "block", "body"));

        // line 6
        echo "    <h1>Exerciceassocie</h1>

    <table class=\"table\">
        <tbody>
            <tr>
                <th>Idexassocier</th>
                <td>";
        // line 12
        echo twig_escape_filter($this->env, twig_get_attribute($this->env, $this->source, (isset($context["exerciceassocie"]) || array_key_exists("exerciceassocie", $context) ? $context["exerciceassocie"] : (function () { throw new RuntimeError('Variable "exerciceassocie" does not exist.', 12, $this->source); })()), "idexassocier", [], "any", false, false, false, 12), "html", null, true);
        echo "</td>
            </tr>
            <tr>
                <th>Idprofile</th>
                <td>";
        // line 16
        echo twig_escape_filter($this->env, twig_get_attribute($this->env, $this->source, (isset($context["exerciceassocie"]) || array_key_exists("exerciceassocie", $context) ? $context["exerciceassocie"] : (function () { throw new RuntimeError('Variable "exerciceassocie" does not exist.', 16, $this->source); })()), "idprofile", [], "any", false, false, false, 16), "html", null, true);
        echo "</td>
            </tr>
            <tr>
                <th>Libelleexercice</th>
                <td>";
        // line 20
        echo twig_escape_filter($this->env, twig_get_attribute($this->env, $this->source, (isset($context["exerciceassocie"]) || array_key_exists("exerciceassocie", $context) ? $context["exerciceassocie"] : (function () { throw new RuntimeError('Variable "exerciceassocie" does not exist.', 20, $this->source); })()), "libelleexercice", [], "any", false, false, false, 20), "html", null, true);
        echo "</td>
            </tr>
            <tr>
                <th>Nbseries</th>
                <td>";
        // line 24
        echo twig_escape_filter($this->env, twig_get_attribute($this->env, $this->source, (isset($context["exerciceassocie"]) || array_key_exists("exerciceassocie", $context) ? $context["exerciceassocie"] : (function () { throw new RuntimeError('Variable "exerciceassocie" does not exist.', 24, $this->source); })()), "nbseries", [], "any", false, false, false, 24), "html", null, true);
        echo "</td>
            </tr>
            <tr>
                <th>Nbrepetitions</th>
                <td>";
        // line 28
        echo twig_escape_filter($this->env, twig_get_attribute($this->env, $this->source, (isset($context["exerciceassocie"]) || array_key_exists("exerciceassocie", $context) ? $context["exerciceassocie"] : (function () { throw new RuntimeError('Variable "exerciceassocie" does not exist.', 28, $this->source); })()), "nbrepetitions", [], "any", false, false, false, 28), "html", null, true);
        echo "</td>
            </tr>
            <tr>
                <th>Jour</th>
                <td>";
        // line 32
        echo twig_escape_filter($this->env, twig_get_attribute($this->env, $this->source, (isset($context["exerciceassocie"]) || array_key_exists("exerciceassocie", $context) ? $context["exerciceassocie"] : (function () { throw new RuntimeError('Variable "exerciceassocie" does not exist.', 32, $this->source); })()), "jour", [], "any", false, false, false, 32), "html", null, true);
        echo "</td>
            </tr>
        </tbody>
    </table>

    <a href=\"";
        // line 37
        echo $this->extensions['Symfony\Bridge\Twig\Extension\RoutingExtension']->getPath("exerciceassocie_index");
        echo "\">back to list</a>

    <a href=\"";
        // line 39
        echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\RoutingExtension']->getPath("exerciceassocie_edit", ["idexassocier" => twig_get_attribute($this->env, $this->source, (isset($context["exerciceassocie"]) || array_key_exists("exerciceassocie", $context) ? $context["exerciceassocie"] : (function () { throw new RuntimeError('Variable "exerciceassocie" does not exist.', 39, $this->source); })()), "idexassocier", [], "any", false, false, false, 39)]), "html", null, true);
        echo "\">edit</a>

    ";
        // line 41
        echo twig_include($this->env, $context, "exerciceassocie/_delete_form.html.twig");
        echo "
";
        
        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02->leave($__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02_prof);

        
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e->leave($__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e_prof);

    }

    public function getTemplateName()
    {
        return "exerciceassocie/show.html.twig";
    }

    public function isTraitable()
    {
        return false;
    }

    public function getDebugInfo()
    {
        return array (  149 => 41,  144 => 39,  139 => 37,  131 => 32,  124 => 28,  117 => 24,  110 => 20,  103 => 16,  96 => 12,  88 => 6,  78 => 5,  59 => 3,  36 => 1,);
    }

    public function getSourceContext()
    {
        return new Source("{% extends 'base.html.twig' %}

{% block title %}Exerciceassocie{% endblock %}

{% block body %}
    <h1>Exerciceassocie</h1>

    <table class=\"table\">
        <tbody>
            <tr>
                <th>Idexassocier</th>
                <td>{{ exerciceassocie.idexassocier }}</td>
            </tr>
            <tr>
                <th>Idprofile</th>
                <td>{{ exerciceassocie.idprofile }}</td>
            </tr>
            <tr>
                <th>Libelleexercice</th>
                <td>{{ exerciceassocie.libelleexercice }}</td>
            </tr>
            <tr>
                <th>Nbseries</th>
                <td>{{ exerciceassocie.nbseries }}</td>
            </tr>
            <tr>
                <th>Nbrepetitions</th>
                <td>{{ exerciceassocie.nbrepetitions }}</td>
            </tr>
            <tr>
                <th>Jour</th>
                <td>{{ exerciceassocie.jour }}</td>
            </tr>
        </tbody>
    </table>

    <a href=\"{{ path('exerciceassocie_index') }}\">back to list</a>

    <a href=\"{{ path('exerciceassocie_edit', {'idexassocier': exerciceassocie.idexassocier}) }}\">edit</a>

    {{ include('exerciceassocie/_delete_form.html.twig') }}
{% endblock %}
", "exerciceassocie/show.html.twig", "C:\\xampp\\htdocs\\pidev\\templates\\exerciceassocie\\show.html.twig");
    }
}
