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
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e->enter($__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "template", "programmealimentaire/show.html.twig"));

        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02 = $this->extensions["Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension"];
        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02->enter($__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "template", "programmealimentaire/show.html.twig"));

        $this->parent = $this->loadTemplate("back.html.twig", "programmealimentaire/show.html.twig", 1);
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

        echo "Programme Alimentaire";
        
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

        echo "Programme Alimentaire";
        
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

        echo "Programme Alimentaire";
        
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
            <h3 class=\"box-title\">Programme Alimentaire</h3>
        </div>

        <div class=\"box-body\">
            <table class=\"table\">
                <tbody>
                <tr>
                    <th>Email Compte & N° Profile</th>
                    <td>";
        // line 20
        echo twig_escape_filter($this->env, twig_get_attribute($this->env, $this->source, twig_get_attribute($this->env, $this->source, twig_get_attribute($this->env, $this->source, (isset($context["programmealimentaire"]) || array_key_exists("programmealimentaire", $context) ? $context["programmealimentaire"] : (function () { throw new RuntimeError('Variable "programmealimentaire" does not exist.', 20, $this->source); })()), "idprofile", [], "any", false, false, false, 20), "emailcompte", [], "any", false, false, false, 20), "email", [], "any", false, false, false, 20), "html", null, true);
        echo " : ";
        echo twig_escape_filter($this->env, twig_get_attribute($this->env, $this->source, twig_get_attribute($this->env, $this->source, (isset($context["programmealimentaire"]) || array_key_exists("programmealimentaire", $context) ? $context["programmealimentaire"] : (function () { throw new RuntimeError('Variable "programmealimentaire" does not exist.', 20, $this->source); })()), "idprofile", [], "any", false, false, false, 20), "id", [], "any", false, false, false, 20), "html", null, true);
        echo "</td>
                </tr>
                <tr>
                    <th>Métabolisme de base (BMR)</th>
                    <td>";
        // line 24
        echo twig_escape_filter($this->env, twig_get_attribute($this->env, $this->source, (isset($context["programmealimentaire"]) || array_key_exists("programmealimentaire", $context) ? $context["programmealimentaire"] : (function () { throw new RuntimeError('Variable "programmealimentaire" does not exist.', 24, $this->source); })()), "bmr", [], "any", false, false, false, 24), "html", null, true);
        echo "</td>
                </tr>
                <tr>
                    <th>Calories Requis</th>
                    <td>";
        // line 28
        echo twig_escape_filter($this->env, twig_get_attribute($this->env, $this->source, (isset($context["programmealimentaire"]) || array_key_exists("programmealimentaire", $context) ? $context["programmealimentaire"] : (function () { throw new RuntimeError('Variable "programmealimentaire" does not exist.', 28, $this->source); })()), "calrequis", [], "any", false, false, false, 28), "html", null, true);
        echo "</td>
                </tr>
                <tr>
                    <th>Lipides Requis</th>
                    <td>";
        // line 32
        echo twig_escape_filter($this->env, twig_get_attribute($this->env, $this->source, (isset($context["programmealimentaire"]) || array_key_exists("programmealimentaire", $context) ? $context["programmealimentaire"] : (function () { throw new RuntimeError('Variable "programmealimentaire" does not exist.', 32, $this->source); })()), "fatsrequis", [], "any", false, false, false, 32), "html", null, true);
        echo "</td>
                </tr>
                <tr>
                    <th>Glucides Requis</th>
                    <td>";
        // line 36
        echo twig_escape_filter($this->env, twig_get_attribute($this->env, $this->source, (isset($context["programmealimentaire"]) || array_key_exists("programmealimentaire", $context) ? $context["programmealimentaire"] : (function () { throw new RuntimeError('Variable "programmealimentaire" does not exist.', 36, $this->source); })()), "carbsrequis", [], "any", false, false, false, 36), "html", null, true);
        echo "</td>
                </tr>
                <tr>
                    <th>Proteines Requis</th>
                    <td>";
        // line 40
        echo twig_escape_filter($this->env, twig_get_attribute($this->env, $this->source, (isset($context["programmealimentaire"]) || array_key_exists("programmealimentaire", $context) ? $context["programmealimentaire"] : (function () { throw new RuntimeError('Variable "programmealimentaire" does not exist.', 40, $this->source); })()), "proteinsrequis", [], "any", false, false, false, 40), "html", null, true);
        echo "</td>
                </tr>
                </tbody>
            </table>

            <a class=\"btn bg-purple btn-flat\" href=\"";
        // line 45
        echo $this->extensions['Symfony\Bridge\Twig\Extension\RoutingExtension']->getPath("programmealimentaire_index");
        echo "\"><i class=\"fa fa-fw fa-arrow-left\"></i> Retour à la liste </a>

            <a class=\"btn bg-purple btn-flat\" href=\"";
        // line 47
        echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\RoutingExtension']->getPath("programmealimentaire_edit", ["idprofile" => twig_get_attribute($this->env, $this->source, twig_get_attribute($this->env, $this->source, (isset($context["programmealimentaire"]) || array_key_exists("programmealimentaire", $context) ? $context["programmealimentaire"] : (function () { throw new RuntimeError('Variable "programmealimentaire" does not exist.', 47, $this->source); })()), "idprofile", [], "any", false, false, false, 47), "id", [], "any", false, false, false, 47)]), "html", null, true);
        echo "\"><i class=\"fa fa-edit\"></i> Modifier </a>

            ";
        // line 49
        echo twig_include($this->env, $context, "programmealimentaire/_delete_form.html.twig");
        echo "
        </div>
    </div>
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
        return array (  195 => 49,  190 => 47,  185 => 45,  177 => 40,  170 => 36,  163 => 32,  156 => 28,  149 => 24,  140 => 20,  128 => 10,  118 => 9,  99 => 7,  80 => 5,  61 => 3,  38 => 1,);
    }

    public function getSourceContext()
    {
        return new Source("{% extends 'back.html.twig' %}

{% block title %}Programme Alimentaire{% endblock %}

{% block header %}Programme Alimentaire{% endblock %}

{% block breadcrumb %}Programme Alimentaire{% endblock %}

{% block body %}
    <div class=\"box\">
        <div class=\"box-header with-border\">
            <h3 class=\"box-title\">Programme Alimentaire</h3>
        </div>

        <div class=\"box-body\">
            <table class=\"table\">
                <tbody>
                <tr>
                    <th>Email Compte & N° Profile</th>
                    <td>{{ programmealimentaire.idprofile.emailcompte.email }} : {{ programmealimentaire.idprofile.id }}</td>
                </tr>
                <tr>
                    <th>Métabolisme de base (BMR)</th>
                    <td>{{ programmealimentaire.bmr }}</td>
                </tr>
                <tr>
                    <th>Calories Requis</th>
                    <td>{{ programmealimentaire.calrequis }}</td>
                </tr>
                <tr>
                    <th>Lipides Requis</th>
                    <td>{{ programmealimentaire.fatsrequis }}</td>
                </tr>
                <tr>
                    <th>Glucides Requis</th>
                    <td>{{ programmealimentaire.carbsrequis }}</td>
                </tr>
                <tr>
                    <th>Proteines Requis</th>
                    <td>{{ programmealimentaire.proteinsrequis }}</td>
                </tr>
                </tbody>
            </table>

            <a class=\"btn bg-purple btn-flat\" href=\"{{ path('programmealimentaire_index') }}\"><i class=\"fa fa-fw fa-arrow-left\"></i> Retour à la liste </a>

            <a class=\"btn bg-purple btn-flat\" href=\"{{ path('programmealimentaire_edit', {'idprofile': programmealimentaire.idprofile.id}) }}\"><i class=\"fa fa-edit\"></i> Modifier </a>

            {{ include('programmealimentaire/_delete_form.html.twig') }}
        </div>
    </div>
{% endblock %}
", "programmealimentaire/show.html.twig", "C:\\wamp64\\www\\pidev\\templates\\programmealimentaire\\show.html.twig");
    }
}
