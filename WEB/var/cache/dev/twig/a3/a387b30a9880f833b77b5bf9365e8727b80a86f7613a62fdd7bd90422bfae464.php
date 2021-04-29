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

/* aliment/index.html.twig */
class __TwigTemplate_fe24aa9855d229c0cb35994fae96ccdbe64b5f5bf6e368c91eb4e0b90adbce0a extends Template
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
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e->enter($__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "template", "aliment/index.html.twig"));

        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02 = $this->extensions["Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension"];
        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02->enter($__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "template", "aliment/index.html.twig"));

        $this->parent = $this->loadTemplate("back.html.twig", "aliment/index.html.twig", 1);
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

        echo "Aliments";
        
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

        echo "Aliments";
        
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

        echo "Aliments";
        
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
            <h3 class=\"box-title\">Liste des Aliments</h3>
            <div class=\"box-tools\">
                <div class=\"input-group input-group-sm hidden-xs\" style=\"width: 150px;\">
                    <div class=\"input-group-btn\">
                        <a  href=\"";
        // line 16
        echo $this->extensions['Symfony\Bridge\Twig\Extension\RoutingExtension']->getPath("aliment_new");
        echo "\" class=\"btn bg-purple btn-flat\"><i class=\"fa fa-plus\"></i> Ajouter un Aliment </a>
                    </div>
                </div>
            </div>
        </div>
        <div class=\"box-body\">
            <table class=\"table table-bordered table-hover\" style=\"text-align: center\">
                <thead>
                <tr>
                    <th style=\"text-align: center\">Nom Aliment</th>
                    <th style=\"text-align: center\">Lipides</th>
                    <th style=\"text-align: center\">Glucides</th>
                    <th style=\"text-align: center\">Proteines</th>
                    <th style=\"text-align: center\">Calories</th>
                    <th style=\"text-align: center\">Source Type</th>
                    <th style=\"text-align: center\">Actions</th>
                </tr>
                </thead>
                <tbody>
                ";
        // line 35
        $context['_parent'] = $context;
        $context['_seq'] = twig_ensure_traversable((isset($context["aliments"]) || array_key_exists("aliments", $context) ? $context["aliments"] : (function () { throw new RuntimeError('Variable "aliments" does not exist.', 35, $this->source); })()));
        $context['_iterated'] = false;
        foreach ($context['_seq'] as $context["_key"] => $context["aliment"]) {
            // line 36
            echo "                    <tr>
                        <td>";
            // line 37
            echo twig_escape_filter($this->env, twig_get_attribute($this->env, $this->source, $context["aliment"], "nom", [], "any", false, false, false, 37), "html", null, true);
            echo "</td>
                        <td>";
            // line 38
            echo twig_escape_filter($this->env, twig_get_attribute($this->env, $this->source, $context["aliment"], "fats", [], "any", false, false, false, 38), "html", null, true);
            echo "</td>
                        <td>";
            // line 39
            echo twig_escape_filter($this->env, twig_get_attribute($this->env, $this->source, $context["aliment"], "carbs", [], "any", false, false, false, 39), "html", null, true);
            echo "</td>
                        <td>";
            // line 40
            echo twig_escape_filter($this->env, twig_get_attribute($this->env, $this->source, $context["aliment"], "proteins", [], "any", false, false, false, 40), "html", null, true);
            echo "</td>
                        <td>";
            // line 41
            echo twig_escape_filter($this->env, twig_get_attribute($this->env, $this->source, $context["aliment"], "calories", [], "any", false, false, false, 41), "html", null, true);
            echo "</td>
                        ";
            // line 42
            if ((0 === twig_compare(twig_get_attribute($this->env, $this->source, $context["aliment"], "type", [], "any", false, false, false, 42), 0))) {
                // line 43
                echo "                            <td>Proteins</td>
                        ";
            }
            // line 45
            echo "                        ";
            if ((0 === twig_compare(twig_get_attribute($this->env, $this->source, $context["aliment"], "type", [], "any", false, false, false, 45), 1))) {
                // line 46
                echo "                            <td>Carbs</td>
                        ";
            }
            // line 48
            echo "                        ";
            if ((0 === twig_compare(twig_get_attribute($this->env, $this->source, $context["aliment"], "type", [], "any", false, false, false, 48), 2))) {
                // line 49
                echo "                            <td>Fats</td>
                        ";
            }
            // line 51
            echo "                        <td>
                            <a href=\"";
            // line 52
            echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\RoutingExtension']->getPath("aliment_show", ["id" => twig_get_attribute($this->env, $this->source, $context["aliment"], "id", [], "any", false, false, false, 52)]), "html", null, true);
            echo "\"><i class=\"fa fa-eye\"></i></a>
                            <a href=\"";
            // line 53
            echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\RoutingExtension']->getPath("aliment_edit", ["id" => twig_get_attribute($this->env, $this->source, $context["aliment"], "id", [], "any", false, false, false, 53)]), "html", null, true);
            echo "\"><i class=\"fa fa-edit\"></i></a>
                        </td>
                    </tr>
                ";
            $context['_iterated'] = true;
        }
        if (!$context['_iterated']) {
            // line 57
            echo "                    <tr>
                        <td colspan=\"8\">Aucun résultat trouvé</td>
                    </tr>
                ";
        }
        $_parent = $context['_parent'];
        unset($context['_seq'], $context['_iterated'], $context['_key'], $context['aliment'], $context['_parent'], $context['loop']);
        $context = array_intersect_key($context, $_parent) + $_parent;
        // line 61
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
        return "aliment/index.html.twig";
    }

    public function isTraitable()
    {
        return false;
    }

    public function getDebugInfo()
    {
        return array (  231 => 61,  222 => 57,  213 => 53,  209 => 52,  206 => 51,  202 => 49,  199 => 48,  195 => 46,  192 => 45,  188 => 43,  186 => 42,  182 => 41,  178 => 40,  174 => 39,  170 => 38,  166 => 37,  163 => 36,  158 => 35,  136 => 16,  128 => 10,  118 => 9,  99 => 7,  80 => 5,  61 => 3,  38 => 1,);
    }

    public function getSourceContext()
    {
        return new Source("{% extends 'back.html.twig' %}

{% block title %}Aliments{% endblock %}

{% block header %}Aliments{% endblock %}

{% block breadcrumb %}Aliments{% endblock %}

{% block body %}
    <div class=\"box\">
        <div class=\"box-header with-border\">
            <h3 class=\"box-title\">Liste des Aliments</h3>
            <div class=\"box-tools\">
                <div class=\"input-group input-group-sm hidden-xs\" style=\"width: 150px;\">
                    <div class=\"input-group-btn\">
                        <a  href=\"{{ path('aliment_new') }}\" class=\"btn bg-purple btn-flat\"><i class=\"fa fa-plus\"></i> Ajouter un Aliment </a>
                    </div>
                </div>
            </div>
        </div>
        <div class=\"box-body\">
            <table class=\"table table-bordered table-hover\" style=\"text-align: center\">
                <thead>
                <tr>
                    <th style=\"text-align: center\">Nom Aliment</th>
                    <th style=\"text-align: center\">Lipides</th>
                    <th style=\"text-align: center\">Glucides</th>
                    <th style=\"text-align: center\">Proteines</th>
                    <th style=\"text-align: center\">Calories</th>
                    <th style=\"text-align: center\">Source Type</th>
                    <th style=\"text-align: center\">Actions</th>
                </tr>
                </thead>
                <tbody>
                {% for aliment in aliments %}
                    <tr>
                        <td>{{ aliment.nom }}</td>
                        <td>{{ aliment.fats }}</td>
                        <td>{{ aliment.carbs }}</td>
                        <td>{{ aliment.proteins }}</td>
                        <td>{{ aliment.calories }}</td>
                        {% if aliment.type == 0 %}
                            <td>Proteins</td>
                        {% endif %}
                        {% if aliment.type == 1 %}
                            <td>Carbs</td>
                        {% endif %}
                        {% if aliment.type == 2 %}
                            <td>Fats</td>
                        {% endif %}
                        <td>
                            <a href=\"{{ path('aliment_show', {'id': aliment.id}) }}\"><i class=\"fa fa-eye\"></i></a>
                            <a href=\"{{ path('aliment_edit', {'id': aliment.id}) }}\"><i class=\"fa fa-edit\"></i></a>
                        </td>
                    </tr>
                {% else %}
                    <tr>
                        <td colspan=\"8\">Aucun résultat trouvé</td>
                    </tr>
                {% endfor %}
                </tbody>
            </table>
        </div>
    </div>
{% endblock %}
", "aliment/index.html.twig", "C:\\wamp64\\www\\pidev\\templates\\aliment\\index.html.twig");
    }
}
