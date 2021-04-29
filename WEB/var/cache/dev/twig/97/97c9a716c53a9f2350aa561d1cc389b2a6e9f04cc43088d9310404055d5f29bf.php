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

/* base.html.twig */
class __TwigTemplate_e205d81826005fbf1bcb23bee86d79bb38d77ec98501c3b1d7eb56c79607c599 extends Template
{
    private $source;
    private $macros = [];

    public function __construct(Environment $env)
    {
        parent::__construct($env);

        $this->source = $this->getSourceContext();

        $this->parent = false;

        $this->blocks = [
            'title' => [$this, 'block_title'],
            'body' => [$this, 'block_body'],
        ];
    }

    protected function doDisplay(array $context, array $blocks = [])
    {
        $macros = $this->macros;
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e = $this->extensions["Symfony\\Bundle\\WebProfilerBundle\\Twig\\WebProfilerExtension"];
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e->enter($__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "template", "base.html.twig"));

        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02 = $this->extensions["Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension"];
        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02->enter($__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "template", "base.html.twig"));

        // line 1
        echo "<!DOCTYPE html>
<html>
<head>
    <meta charset=\"utf-8\">
    <meta http-equiv=\"x-ua-compatible\" content=\"ie=edge\">
    <title>";
        // line 6
        $this->displayBlock('title', $context, $blocks);
        echo "</title>
    <meta name=\"description\" content=\"\">
    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">
    <link rel=\"manifest\" href=\"site.webmanifest\">
    <link rel=\"shortcut icon\" type=\"image/x-icon\" href=\"/front/assets/img/favicon.ico\">

    <!-- CSS here -->
    <link rel=\"stylesheet\" href=\"/front/assets/css/bootstrap.min.css\">
    <link rel=\"stylesheet\" href=\"/front/assets/css/owl.carousel.min.css\">
    <link rel=\"stylesheet\" href=\"/front/assets/css/slicknav.css\">
    <link rel=\"stylesheet\" href=\"/front/assets/css/flaticon.css\">
    <link rel=\"stylesheet\" href=\"/front/assets/css/gijgo.css\">
    <link rel=\"stylesheet\" href=\"/front/assets/css/animate.min.css\">
    <link rel=\"stylesheet\" href=\"/front/assets/css/animated-headline.css\">
    <link rel=\"stylesheet\" href=\"/front/assets/css/magnific-popup.css\">
    <link rel=\"stylesheet\" href=\"/front/assets/css/fontawesome-all.min.css\">
    <link rel=\"stylesheet\" href=\"/front/assets/css/themify-icons.css\">
    <link rel=\"stylesheet\" href=\"/front/assets/css/slick.css\">
    <link rel=\"stylesheet\" href=\"/front/assets/css/nice-select.css\">
    <link rel=\"stylesheet\" href=\"/front/assets/css/style.css\">
</head>
    <body>
        <header>
            <!--? Header Start -->
            <div class=\"header-area header-transparent\">
                <div class=\"main-header header-sticky\">
                    <div class=\"container-fluid\">
                        <div class=\"row align-items-center\">
                            <!-- Logo -->
                            <div class=\"col-xl-2 col-lg-2 col-md-1\">
                                <div class=\"logo\">
                                    <a href=\"index.html\"><img src=\"";
        // line 37
        echo twig_escape_filter($this->env, $this->extensions['Symfony\Bridge\Twig\Extension\AssetExtension']->getAssetUrl("/front/assets/img/logo/logo.png"), "html", null, true);
        echo "\" alt=\"\"></a>
                                </div>
                            </div>
                            <div class=\"col-xl-10 col-lg-10 col-md-10\">
                                <div class=\"menu-main d-flex align-items-center justify-content-end\">
                                    <!-- Main-menu -->
                                    <div class=\"main-menu f-right d-none d-lg-block\">
                                        <nav>
                                            <ul id=\"navigation\">
                                                <li><a href=\"index.html\">Home</a></li>
                                                <li><a href=\"about.html\">About</a></li>
                                                <li><a href=\"services.html\">Services</a></li>
                                                <li><a href=\"schedule.html\">schedule</a></li>
                                                <li><a href=\"gallery.html\">gallery</a></li>
                                                <li><a href=\"blog.html\">Blog</a>
                                                    <ul class=\"submenu\">
                                                        <li><a href=\"blog.html\">Blog</a></li>
                                                        <li><a href=\"blog_details.html\">Blog Details</a></li>
                                                        <li><a href=\"elements.html\">Element</a></li>
                                                    </ul>
                                                </li>
                                                <li><a href=\"contact.html\">Contact</a></li>
                                            </ul>
                                        </nav>
                                    </div>
                                    <div class=\"header-right-btn f-right d-none d-lg-block ml-30\">
                                        <a href=\"from.html\" class=\"btn header-btn\">became a member</a>
                                    </div>
                                </div>
                            </div>
                            <!-- Mobile Menu -->
                            <div class=\"col-12\">
                                <div class=\"mobile_menu d-block d-lg-none\"></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Header End -->
        </header>
        <main>
            ";
        // line 78
        $this->displayBlock('body', $context, $blocks);
        // line 79
        echo "        </main>

        <!-- JS here -->

        <script src=\"/front/assets/js/vendor/modernizr-3.5.0.min.js\"></script>
        <!-- Jquery, Popper, Bootstrap -->
        <script src=\"/front/assets/js/vendor/jquery-1.12.4.min.js\"></script>
        <script src=\"/front/assets/js/popper.min.js\"></script>
        <script src=\"/front/assets/js/bootstrap.min.js\"></script>
        <!-- Jquery Mobile Menu -->
        <script src=\"/front/assets/js/jquery.slicknav.min.js\"></script>

        <!-- Jquery Slick , Owl-Carousel Plugins -->
        <script src=\"/front/assets/js/owl.carousel.min.js\"></script>
        <script src=\"/front/assets/js/slick.min.js\"></script>
        <!-- One Page, Animated-HeadLin -->
        <script src=\"/front/assets/js/wow.min.js\"></script>
        <script src=\"/front/assets/js/animated.headline.js\"></script>
        <script src=\"/front/assets/js/jquery.magnific-popup.js\"></script>

        <!-- Date Picker -->
        <script src=\"/front/assets/js/gijgo.min.js\"></script>
        <!-- Nice-select, sticky -->
        <script src=\"/front/assets/js/jquery.nice-select.min.js\"></script>
        <script src=\"/front/assets/js/jquery.sticky.js\"></script>

        <!-- counter , waypoint,Hover Direction -->
        <script src=\"/front/assets/js/jquery.counterup.min.js\"></script>
        <script src=\"/front/assets/js/waypoints.min.js\"></script>
        <script src=\"/front/assets/js/jquery.countdown.min.js\"></script>
        <script src=\"/front/assets/js/hover-direction-snake.min.js\"></script>

        <!-- contact js -->
        <script src=\"/front/assets/js/contact.js\"></script>
        <script src=\"/frontassets/js/jquery.form.js\"></script>
        <script src=\"/frontassets/js/jquery.validate.min.js\"></script>
        <script src=\"/frontassets/js/mail-script.js\"></script>
        <script src=\"/frontassets/js/jquery.ajaxchimp.min.js\"></script>

        <!-- Jquery Plugins, main Jquery -->
        <script src=\"/frontassets/js/plugins.js\"></script>
        <script src=\"/front/assets/js/main.js\"></script>
    </body>
</html>
";
        
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e->leave($__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e_prof);

        
        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02->leave($__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02_prof);

    }

    // line 6
    public function block_title($context, array $blocks = [])
    {
        $macros = $this->macros;
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e = $this->extensions["Symfony\\Bundle\\WebProfilerBundle\\Twig\\WebProfilerExtension"];
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e->enter($__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "block", "title"));

        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02 = $this->extensions["Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension"];
        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02->enter($__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "block", "title"));

        echo "Welcome!";
        
        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02->leave($__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02_prof);

        
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e->leave($__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e_prof);

    }

    // line 78
    public function block_body($context, array $blocks = [])
    {
        $macros = $this->macros;
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e = $this->extensions["Symfony\\Bundle\\WebProfilerBundle\\Twig\\WebProfilerExtension"];
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e->enter($__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "block", "body"));

        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02 = $this->extensions["Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension"];
        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02->enter($__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "block", "body"));

        
        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02->leave($__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02_prof);

        
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e->leave($__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e_prof);

    }

    public function getTemplateName()
    {
        return "base.html.twig";
    }

    public function isTraitable()
    {
        return false;
    }

    public function getDebugInfo()
    {
        return array (  205 => 78,  186 => 6,  132 => 79,  130 => 78,  86 => 37,  52 => 6,  45 => 1,);
    }

    public function getSourceContext()
    {
        return new Source("<!DOCTYPE html>
<html>
<head>
    <meta charset=\"utf-8\">
    <meta http-equiv=\"x-ua-compatible\" content=\"ie=edge\">
    <title>{% block title %}Welcome!{% endblock %}</title>
    <meta name=\"description\" content=\"\">
    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">
    <link rel=\"manifest\" href=\"site.webmanifest\">
    <link rel=\"shortcut icon\" type=\"image/x-icon\" href=\"/front/assets/img/favicon.ico\">

    <!-- CSS here -->
    <link rel=\"stylesheet\" href=\"/front/assets/css/bootstrap.min.css\">
    <link rel=\"stylesheet\" href=\"/front/assets/css/owl.carousel.min.css\">
    <link rel=\"stylesheet\" href=\"/front/assets/css/slicknav.css\">
    <link rel=\"stylesheet\" href=\"/front/assets/css/flaticon.css\">
    <link rel=\"stylesheet\" href=\"/front/assets/css/gijgo.css\">
    <link rel=\"stylesheet\" href=\"/front/assets/css/animate.min.css\">
    <link rel=\"stylesheet\" href=\"/front/assets/css/animated-headline.css\">
    <link rel=\"stylesheet\" href=\"/front/assets/css/magnific-popup.css\">
    <link rel=\"stylesheet\" href=\"/front/assets/css/fontawesome-all.min.css\">
    <link rel=\"stylesheet\" href=\"/front/assets/css/themify-icons.css\">
    <link rel=\"stylesheet\" href=\"/front/assets/css/slick.css\">
    <link rel=\"stylesheet\" href=\"/front/assets/css/nice-select.css\">
    <link rel=\"stylesheet\" href=\"/front/assets/css/style.css\">
</head>
    <body>
        <header>
            <!--? Header Start -->
            <div class=\"header-area header-transparent\">
                <div class=\"main-header header-sticky\">
                    <div class=\"container-fluid\">
                        <div class=\"row align-items-center\">
                            <!-- Logo -->
                            <div class=\"col-xl-2 col-lg-2 col-md-1\">
                                <div class=\"logo\">
                                    <a href=\"index.html\"><img src=\"{{ asset('/front/assets/img/logo/logo.png') }}\" alt=\"\"></a>
                                </div>
                            </div>
                            <div class=\"col-xl-10 col-lg-10 col-md-10\">
                                <div class=\"menu-main d-flex align-items-center justify-content-end\">
                                    <!-- Main-menu -->
                                    <div class=\"main-menu f-right d-none d-lg-block\">
                                        <nav>
                                            <ul id=\"navigation\">
                                                <li><a href=\"index.html\">Home</a></li>
                                                <li><a href=\"about.html\">About</a></li>
                                                <li><a href=\"services.html\">Services</a></li>
                                                <li><a href=\"schedule.html\">schedule</a></li>
                                                <li><a href=\"gallery.html\">gallery</a></li>
                                                <li><a href=\"blog.html\">Blog</a>
                                                    <ul class=\"submenu\">
                                                        <li><a href=\"blog.html\">Blog</a></li>
                                                        <li><a href=\"blog_details.html\">Blog Details</a></li>
                                                        <li><a href=\"elements.html\">Element</a></li>
                                                    </ul>
                                                </li>
                                                <li><a href=\"contact.html\">Contact</a></li>
                                            </ul>
                                        </nav>
                                    </div>
                                    <div class=\"header-right-btn f-right d-none d-lg-block ml-30\">
                                        <a href=\"from.html\" class=\"btn header-btn\">became a member</a>
                                    </div>
                                </div>
                            </div>
                            <!-- Mobile Menu -->
                            <div class=\"col-12\">
                                <div class=\"mobile_menu d-block d-lg-none\"></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Header End -->
        </header>
        <main>
            {% block body %}{% endblock %}
        </main>

        <!-- JS here -->

        <script src=\"/front/assets/js/vendor/modernizr-3.5.0.min.js\"></script>
        <!-- Jquery, Popper, Bootstrap -->
        <script src=\"/front/assets/js/vendor/jquery-1.12.4.min.js\"></script>
        <script src=\"/front/assets/js/popper.min.js\"></script>
        <script src=\"/front/assets/js/bootstrap.min.js\"></script>
        <!-- Jquery Mobile Menu -->
        <script src=\"/front/assets/js/jquery.slicknav.min.js\"></script>

        <!-- Jquery Slick , Owl-Carousel Plugins -->
        <script src=\"/front/assets/js/owl.carousel.min.js\"></script>
        <script src=\"/front/assets/js/slick.min.js\"></script>
        <!-- One Page, Animated-HeadLin -->
        <script src=\"/front/assets/js/wow.min.js\"></script>
        <script src=\"/front/assets/js/animated.headline.js\"></script>
        <script src=\"/front/assets/js/jquery.magnific-popup.js\"></script>

        <!-- Date Picker -->
        <script src=\"/front/assets/js/gijgo.min.js\"></script>
        <!-- Nice-select, sticky -->
        <script src=\"/front/assets/js/jquery.nice-select.min.js\"></script>
        <script src=\"/front/assets/js/jquery.sticky.js\"></script>

        <!-- counter , waypoint,Hover Direction -->
        <script src=\"/front/assets/js/jquery.counterup.min.js\"></script>
        <script src=\"/front/assets/js/waypoints.min.js\"></script>
        <script src=\"/front/assets/js/jquery.countdown.min.js\"></script>
        <script src=\"/front/assets/js/hover-direction-snake.min.js\"></script>

        <!-- contact js -->
        <script src=\"/front/assets/js/contact.js\"></script>
        <script src=\"/frontassets/js/jquery.form.js\"></script>
        <script src=\"/frontassets/js/jquery.validate.min.js\"></script>
        <script src=\"/frontassets/js/mail-script.js\"></script>
        <script src=\"/frontassets/js/jquery.ajaxchimp.min.js\"></script>

        <!-- Jquery Plugins, main Jquery -->
        <script src=\"/frontassets/js/plugins.js\"></script>
        <script src=\"/front/assets/js/main.js\"></script>
    </body>
</html>
", "base.html.twig", "C:\\wamp64\\www\\pidev\\templates\\base.html.twig");
    }
}
