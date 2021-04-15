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

/* programmealimentaire/show.html.twig */
class __TwigTemplate_947cb40a9fa791ffa7315886a5c98c87a2a4301b046b0a4d96f9eb6e419423b8 extends Template
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
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e->enter($__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "template", "programmealimentaire/show.html.twig"));

        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02 = $this->extensions["Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension"];
        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02->enter($__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "template", "programmealimentaire/show.html.twig"));

        $this->parent = $this->loadTemplate("base.html.twig", "programmealimentaire/show.html.twig", 1);
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

        echo "Programmealimentaire";
        
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
        echo "    <h1>Programmealimentaire</h1>

    <table class=\"table\">
        <tbody>
            <tr>
                <th>Idprofile</th>
                <td>";
        // line 12
        echo twig_escape_filter($this->env, twig_get_attribute($this->env, $this->source, (isset($context["programmealimentaire"]) || array_key_exists("programmealimentaire", $context) ? $context["programmealimentaire"] : (function () { throw new RuntimeError('Variable "programmealimentaire" does not exist.', 12, $this->source); })()), "idprofile", [], "any", false, false, false, 12), "html", null, true);
        echo "</td>
            </tr>
            <tr>
                <th>Bmr</th>
                <td>";
        // line 16
        echo twig_escape_filter($this->env, twig_get_attribute($this->env, $this->source, (isset($context["programmealimentaire"]) || array_key_exists("programmealimentaire", $context) ? $context["programmealimentaire"] : (function () { throw new RuntimeError('Variable "programmealimentaire" does not exist.', 16, $this->source); })()), "bmr", [], "any", false, false, false, 16), "html", null, true);
        echo "</td>
            </tr>
            <tr>
                <th>Calrequis</th>
                <td>";
        // line 20
        echo twig_escape_filter($this->env, twig_get_attribute($this->env, $this->source, (isset($context["programmealimentaire"]) || array_key_exists("programmealimentaire", $context) ? $context["programmealimentaire"] : (function () { throw new RuntimeError('Variable "programmealimentaire" does not exist.', 20, $this->source); })()), "calrequis", [], "any", false, false, false, 20), "html", null, true);
        echo "</td>
            </tr>
            <tr>
                <th>Fatsrequis</th>
                <td>";
        // line 24
        echo twig_escape_filter($this->env, twig_get_attribute($this->env, $this->source, (isset($context["programmealimentaire"]) || array_key_exists("programmealimentaire", $context) ? $context["programmealimentaire"] : (function () { throw new RuntimeError('Variable "programmealimentaire" does not exist.', 24, $this->source); })()), "fatsrequis", [], "any", false, false, false, 24), "html", null, true);
        echo "</td>
            </tr>
            <tr>
                <th>Carbsrequis</th>
                <td>";
        // line 28
        echo twig_escape_filter($this->env, twig_get_attribute($this->env, $this->source, (isset($context["programmealimentaire"]) || array_key_exists("programmealimentaire", $context) ? $context["programmealimentaire"] : (function () { throw new RuntimeError('Variable "programmealimentaire" does not exist.', 28, $this->source); })()), "carbsrequis", [], "any", false, false, false, 28), "html", null, true);
        echo "</td>
            </tr>
            <tr>
                <th>Proteinsrequis</th>
                <td>";
        // line 32
        echo twig_escape_filter($this->env, twig_get_attribute($this->env, $this->source, (isset($context["programmealimentaire"]) || array_key_exists("programmealimentaire", $context) ? $context["programmealimentaire"] : (function () { throw new RuntimeError('Variable "programmealimentaire" does not exist.', 32, $this->source); })()), "proteinsrequis", [], "any", false, false, false, 32), "html", null, true);
        echo "</td>
            </tr>
        </tbody>
    </table>

    <a href=\"";
        // line 37
        echo $this->extensions['Symfony\Bridge\Twig\Extension\RoutingExtension']->getPath("programmealimentaire_index");
        echo "\">back to list</a>

    <a href=\"";
        // line 39
        echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\RoutingExtension']->getPath("programmealimentaire_edit", ["idprofile" => twig_get_attribute($this->env, $this->source, (isset($context["programmealimentaire"]) || array_key_exists("programmealimentaire", $context) ? $context["programmealimentaire"] : (function () { throw new RuntimeError('Variable "programmealimentaire" does not exist.', 39, $this->source); })()), "idprofile", [], "any", false, false, false, 39)]), "html", null, true);
        echo "\">edit</a>

    ";
        // line 41
        echo twig_include($this->env, $context, "programmealimentaire/_delete_form.html.twig");
        echo "
";
        
        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02->leave($__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02_prof);

        
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e->leave($__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e_prof);

    }

    public function getTemplateName()
    {
        return "programmealimentaire/show.html.twig";
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

{% block title %}Programmealimentaire{% endblock %}

{% block body %}
    <h1>Programmealimentaire</h1>

    <table class=\"table\">
        <tbody>
            <tr>
                <th>Idprofile</th>
                <td>{{ programmealimentaire.idprofile }}</td>
            </tr>
            <tr>
                <th>Bmr</th>
                <td>{{ programmealimentaire.bmr }}</td>
            </tr>
            <tr>
                <th>Calrequis</th>
                <td>{{ programmealimentaire.calrequis }}</td>
            </tr>
            <tr>
                <th>Fatsrequis</th>
                <td>{{ programmealimentaire.fatsrequis }}</td>
            </tr>
            <tr>
                <th>Carbsrequis</th>
                <td>{{ programmealimentaire.carbsrequis }}</td>
            </tr>
            <tr>
                <th>Proteinsrequis</th>
                <td>{{ programmealimentaire.proteinsrequis }}</td>
            </tr>
        </tbody>
    </table>

    <a href=\"{{ path('programmealimentaire_index') }}\">back to list</a>

    <a href=\"{{ path('programmealimentaire_edit', {'idprofile': programmealimentaire.idprofile}) }}\">edit</a>

    {{ include('programmealimentaire/_delete_form.html.twig') }}
{% endblock %}
", "programmealimentaire/show.html.twig", "C:\\xampp\\htdocs\\pidev\\templates\\programmealimentaire\\show.html.twig");
    }
}
