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

/* front/index.html.twig */
class __TwigTemplate_15517163fb9ee86bbd0e91934701ab0c81310cc9d6be2c5d7a80d84a80ca2466 extends Template
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
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e->enter($__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "template", "front/index.html.twig"));

        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02 = $this->extensions["Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension"];
        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02->enter($__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "template", "front/index.html.twig"));

        $this->parent = $this->loadTemplate("base.html.twig", "front/index.html.twig", 1);
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

        echo "Hello FrontController!";
        
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
        echo "    <div class=\"slider-area2\">
        <div class=\"slider-height2 d-flex align-items-center\">
            <div class=\"container\">
                <div class=\"row\">
                    <div class=\"col-xl-12\">
                        <div class=\"hero-cap hero-cap2 text-center pt-70\">
                            <h2>Shop</h2>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <section class=\"services-area pt-100 pb-150\">
        <!--? Want To work -->
        <section class=\"wantToWork-area w-padding\">
            <div class=\"container\">
                <div class=\"row align-items-end justify-content-between\">
                    <div class=\"col-lg-6 col-md-10 col-sm-10\">
                        <div class=\"section-tittle\">
                            <span>oUR sERVICES FOR YOU</span>
                            <h2>PUSH YOUR LIMITS FORWARD We Offer to you</h2>
                        </div>
                    </div>
                    <div class=\"col-xl-2 col-lg-2 col-md-3\">
                        <a href=\"services.html\" class=\"btn wantToWork-btn f-right\">More Services</a>
                    </div>
                </div>
            </div>
        </section>
        <!-- Want To work End -->
        <div class=\"container\">
            <div class=\"row\">
                <div class=\"col-lg-4 col-md-4 col-sm-6\">
                    <div class=\"single-cat single-cat2 text-center mb-50\">
                        <div class=\"cat-icon\">
                            <i class=\"flaticon-fitness\"></i>
                        </div>
                        <div class=\"cat-cap\">
                            <h5><a href=\"services.html\">QUALITY EQUIPMENT</a></h5>
                            <p>The sea freight service has grown consider ably in recent years. We spend timetting to kn.</p>
                        </div>
                        <div class=\"img-cap\">
                            <a href=\"services.html\" class=\"\">Discover More About Us <i class=\"ti-arrow-right\"></i></a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
";
        
        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02->leave($__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02_prof);

        
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e->leave($__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e_prof);

    }

    public function getTemplateName()
    {
        return "front/index.html.twig";
    }

    public function isTraitable()
    {
        return false;
    }

    public function getDebugInfo()
    {
        return array (  88 => 6,  78 => 5,  59 => 3,  36 => 1,);
    }

    public function getSourceContext()
    {
        return new Source("{% extends 'base.html.twig' %}

{% block title %}Hello FrontController!{% endblock %}

{% block body %}
    <div class=\"slider-area2\">
        <div class=\"slider-height2 d-flex align-items-center\">
            <div class=\"container\">
                <div class=\"row\">
                    <div class=\"col-xl-12\">
                        <div class=\"hero-cap hero-cap2 text-center pt-70\">
                            <h2>Shop</h2>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <section class=\"services-area pt-100 pb-150\">
        <!--? Want To work -->
        <section class=\"wantToWork-area w-padding\">
            <div class=\"container\">
                <div class=\"row align-items-end justify-content-between\">
                    <div class=\"col-lg-6 col-md-10 col-sm-10\">
                        <div class=\"section-tittle\">
                            <span>oUR sERVICES FOR YOU</span>
                            <h2>PUSH YOUR LIMITS FORWARD We Offer to you</h2>
                        </div>
                    </div>
                    <div class=\"col-xl-2 col-lg-2 col-md-3\">
                        <a href=\"services.html\" class=\"btn wantToWork-btn f-right\">More Services</a>
                    </div>
                </div>
            </div>
        </section>
        <!-- Want To work End -->
        <div class=\"container\">
            <div class=\"row\">
                <div class=\"col-lg-4 col-md-4 col-sm-6\">
                    <div class=\"single-cat single-cat2 text-center mb-50\">
                        <div class=\"cat-icon\">
                            <i class=\"flaticon-fitness\"></i>
                        </div>
                        <div class=\"cat-cap\">
                            <h5><a href=\"services.html\">QUALITY EQUIPMENT</a></h5>
                            <p>The sea freight service has grown consider ably in recent years. We spend timetting to kn.</p>
                        </div>
                        <div class=\"img-cap\">
                            <a href=\"services.html\" class=\"\">Discover More About Us <i class=\"ti-arrow-right\"></i></a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
{% endblock %}
", "front/index.html.twig", "C:\\xampp\\htdocs\\pidev\\templates\\front\\index.html.twig");
    }
}
