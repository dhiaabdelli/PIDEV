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

/* back.html.twig */
class __TwigTemplate_79bea2406db6d532df3e1d6b4cc613ecf480a7f23bff4bc1ba7c1cd6a5552b61 extends Template
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
            'header' => [$this, 'block_header'],
            'breadcrumb' => [$this, 'block_breadcrumb'],
            'body' => [$this, 'block_body'],
        ];
    }

    protected function doDisplay(array $context, array $blocks = [])
    {
        $macros = $this->macros;
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e = $this->extensions["Symfony\\Bundle\\WebProfilerBundle\\Twig\\WebProfilerExtension"];
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e->enter($__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "template", "back.html.twig"));

        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02 = $this->extensions["Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension"];
        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02->enter($__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "template", "back.html.twig"));

        // line 1
        $context["page"] = twig_get_attribute($this->env, $this->source, twig_get_attribute($this->env, $this->source, (isset($context["app"]) || array_key_exists("app", $context) ? $context["app"] : (function () { throw new RuntimeError('Variable "app" does not exist.', 1, $this->source); })()), "request", [], "any", false, false, false, 1), "get", [0 => "_route"], "method", false, false, false, 1);
        // line 2
        echo "
<!DOCTYPE html>
<html>
<head>
    <meta charset=\"utf-8\">
    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">
    <title>";
        // line 8
        $this->displayBlock('title', $context, $blocks);
        echo "</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content=\"width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no\" name=\"viewport\">
    <!-- Bootstrap 3.3.7 -->
    <link rel=\"stylesheet\" href=\"/back/bower_components/bootstrap/dist/css/bootstrap.min.css\">
    <!-- Font Awesome -->
    <link rel=\"stylesheet\" href=\"/back/bower_components/font-awesome/css/font-awesome.min.css\">
    <!-- Ionicons -->
    <link rel=\"stylesheet\" href=\"/back/bower_components/Ionicons/css/ionicons.min.css\">
    <!-- Theme style -->
    <link rel=\"stylesheet\" href=\"/back/dist/css/AdminLTE.min.css\">
    <!-- AdminLTE Skins. Choose a skin from the css/skins
         folder instead of downloading all of them to reduce the load. -->
    <link rel=\"stylesheet\" href=\"/back/dist/css/skins/_all-skins.min.css\">
    <!-- Morris chart -->
    <link rel=\"stylesheet\" href=\"/back/bower_components/morris.js/morris.css\">
    <!-- jvectormap -->
    <link rel=\"stylesheet\" href=\"/back/bower_components/jvectormap/jquery-jvectormap.css\">
    <!-- Date Picker -->
    <link rel=\"stylesheet\" href=\"/back/bower_components/bootstrap-datepicker/dist/css/bootstrap-datepicker.min.css\">
    <!-- Daterange picker -->
    <link rel=\"stylesheet\" href=\"/back/bower_components/bootstrap-daterangepicker/daterangepicker.css\">
    <!-- bootstrap wysihtml5 - text editor -->
    <link rel=\"stylesheet\" href=\"/back/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css\">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src=\"https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js\"></script>
    <script src=\"https://oss.maxcdn.com/respond/1.4.2/respond.min.js\"></script>
    <![endif]-->

    <!-- Google Font -->
    <link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic\">
</head>
<body class=\"fixed hold-transition skin-purple-light sidebar-mini\">
    <div class=\"wrapper\">
        <header class=\"main-header\">
            <!-- Logo -->
            <a class=\"logo\">
                <!-- mini logo for sidebar mini 50x50 pixels -->
                <span class=\"logo-mini\"><b>e</b>IR</span>
                <!-- logo for regular state and mobile devices -->
                <span class=\"logo-lg\"><b>elix</b>IR</span>
            </a>
            <!-- Header Navbar: style can be found in header.less -->
            <nav class=\"navbar navbar-static-top\">
                <!-- Sidebar toggle button-->
                <a href=\"#\" class=\"sidebar-toggle\" data-toggle=\"push-menu\" role=\"button\">
                    <span class=\"sr-only\">Toggle navigation</span>
                </a>

                <div class=\"navbar-custom-menu\">
                    <ul class=\"nav navbar-nav\">
                        <li class=\"dropdown user user-menu\">
                            <a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\">
                                <img src=\"dist/img/user2-160x160.jpg\" class=\"user-image\" alt=\"User Image\">
                                <span class=\"hidden-xs\">Alexander Pierce</span>
                            </a>
                            <ul class=\"dropdown-menu\">
                                <!-- User image -->
                                <li class=\"user-header\">
                                    <img src=\"dist/img/user2-160x160.jpg\" class=\"img-circle\" alt=\"User Image\">

                                    <p>
                                        Alexander Pierce - Web Developer
                                        <small>Member since Nov. 2012</small>
                                    </p>
                                </li>
                                <!-- Menu Body -->
                                <li class=\"user-body\">
                                    <div class=\"row\">
                                        <div class=\"col-xs-4 text-center\">
                                            <a href=\"#\">Followers</a>
                                        </div>
                                        <div class=\"col-xs-4 text-center\">
                                            <a href=\"#\">Sales</a>
                                        </div>
                                        <div class=\"col-xs-4 text-center\">
                                            <a href=\"#\">Friends</a>
                                        </div>
                                    </div>
                                    <!-- /.row -->
                                </li>
                                <!-- Menu Footer-->
                                <li class=\"user-footer\">
                                    <div class=\"pull-left\">
                                        <a href=\"#\" class=\"btn btn-default btn-flat\">Profile</a>
                                    </div>
                                    <div class=\"pull-right\">
                                        <a href=\"#\" class=\"btn btn-default btn-flat\">Sign out</a>
                                    </div>
                                </li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </nav>
        </header>

        <aside class=\"main-sidebar\">
            <!-- sidebar: style can be found in sidebar.less -->
            <section class=\"sidebar\">
                <ul class=\"sidebar-menu\" data-widget=\"tree\">
                    <li class=\"header\">MAIN NAVIGATION</li>
                    <li>
                        <a href=\"/\">
                            <i class=\"fa fa-dashboard\"></i> <span>Dashboard</span>
                        </a>
                    </li>
                    <li class=\"";
        // line 118
        if (twig_in_filter(twig_get_attribute($this->env, $this->source, twig_get_attribute($this->env, $this->source, twig_get_attribute($this->env, $this->source, (isset($context["app"]) || array_key_exists("app", $context) ? $context["app"] : (function () { throw new RuntimeError('Variable "app" does not exist.', 118, $this->source); })()), "request", [], "any", false, false, false, 118), "attributes", [], "any", false, false, false, 118), "get", [0 => "_route"], "method", false, false, false, 118), [0 => "categorie_index", 1 => "categorie_new", 2 => "categorie_show", 3 => "categorie_edit", 4 => "categorie_delete", 5 => "produit_index", 6 => "produit_new", 7 => "produit_show", 8 => "produit_edit", 9 => "produit_delete", 10 => "evaluation_index", 11 => "evaluation_new", 12 => "evaluation_show", 13 => "evaluation_edit", 14 => "evaluation_delete"])) {
            // line 134
            echo " active";
        }
        echo " treeview\">
                        <a href=\"#\">
                            <i class=\"fa fa-book\"></i> <span>Gestion des Produits</span>
                            <span class=\"pull-right-container\"><i class=\"fa fa-angle-left pull-right\"></i></span>
                        </a>
                        <ul class=\"treeview-menu\">
                            <li class=\"";
        // line 140
        if ((is_string($__internal_f607aeef2c31a95a7bf963452dff024ffaeb6aafbe4603f9ca3bec57be8633f4 = twig_get_attribute($this->env, $this->source, twig_get_attribute($this->env, $this->source, twig_get_attribute($this->env, $this->source, (isset($context["app"]) || array_key_exists("app", $context) ? $context["app"] : (function () { throw new RuntimeError('Variable "app" does not exist.', 140, $this->source); })()), "request", [], "any", false, false, false, 140), "attributes", [], "any", false, false, false, 140), "get", [0 => "_route"], "method", false, false, false, 140)) && is_string($__internal_62824350bc4502ee19dbc2e99fc6bdd3bd90e7d8dd6e72f42c35efd048542144 = "categorie") && ('' === $__internal_62824350bc4502ee19dbc2e99fc6bdd3bd90e7d8dd6e72f42c35efd048542144 || 0 === strpos($__internal_f607aeef2c31a95a7bf963452dff024ffaeb6aafbe4603f9ca3bec57be8633f4, $__internal_62824350bc4502ee19dbc2e99fc6bdd3bd90e7d8dd6e72f42c35efd048542144)))) {
            echo " active";
        }
        echo "\"><a href=\"/categorie\"><i class=\"fa fa-circle-o\"></i> Categorie</a></li>
                            <li class=\"";
        // line 141
        if ((is_string($__internal_1cfccaec8dd2e8578ccb026fbe7f2e7e29ac2ed5deb976639c5fc99a6ea8583b = twig_get_attribute($this->env, $this->source, twig_get_attribute($this->env, $this->source, twig_get_attribute($this->env, $this->source, (isset($context["app"]) || array_key_exists("app", $context) ? $context["app"] : (function () { throw new RuntimeError('Variable "app" does not exist.', 141, $this->source); })()), "request", [], "any", false, false, false, 141), "attributes", [], "any", false, false, false, 141), "get", [0 => "_route"], "method", false, false, false, 141)) && is_string($__internal_68aa442c1d43d3410ea8f958ba9090f3eaa9a76f8de8fc9be4d6c7389ba28002 = "produit") && ('' === $__internal_68aa442c1d43d3410ea8f958ba9090f3eaa9a76f8de8fc9be4d6c7389ba28002 || 0 === strpos($__internal_1cfccaec8dd2e8578ccb026fbe7f2e7e29ac2ed5deb976639c5fc99a6ea8583b, $__internal_68aa442c1d43d3410ea8f958ba9090f3eaa9a76f8de8fc9be4d6c7389ba28002)))) {
            echo " active";
        }
        echo "\"><a href=\"/produit\"><i class=\"fa fa-circle-o\"></i>Produit</a></li>
                            <li class=\"";
        // line 142
        if ((is_string($__internal_d7fc55f1a54b629533d60b43063289db62e68921ee7a5f8de562bd9d4a2b7ad4 = twig_get_attribute($this->env, $this->source, twig_get_attribute($this->env, $this->source, twig_get_attribute($this->env, $this->source, (isset($context["app"]) || array_key_exists("app", $context) ? $context["app"] : (function () { throw new RuntimeError('Variable "app" does not exist.', 142, $this->source); })()), "request", [], "any", false, false, false, 142), "attributes", [], "any", false, false, false, 142), "get", [0 => "_route"], "method", false, false, false, 142)) && is_string($__internal_01476f8db28655ee4ee02ea2d17dd5a92599be76304f08cd8bc0e05aced30666 = "evaluation") && ('' === $__internal_01476f8db28655ee4ee02ea2d17dd5a92599be76304f08cd8bc0e05aced30666 || 0 === strpos($__internal_d7fc55f1a54b629533d60b43063289db62e68921ee7a5f8de562bd9d4a2b7ad4, $__internal_01476f8db28655ee4ee02ea2d17dd5a92599be76304f08cd8bc0e05aced30666)))) {
            echo " active";
        }
        echo "\"><a href=\"/evaluation\"><i class=\"fa fa-circle-o\"></i>Evaluation</a></li>
                        </ul>
                    </li>
                    <li class=\"";
        // line 145
        if (twig_in_filter(twig_get_attribute($this->env, $this->source, twig_get_attribute($this->env, $this->source, twig_get_attribute($this->env, $this->source, (isset($context["app"]) || array_key_exists("app", $context) ? $context["app"] : (function () { throw new RuntimeError('Variable "app" does not exist.', 145, $this->source); })()), "request", [], "any", false, false, false, 145), "attributes", [], "any", false, false, false, 145), "get", [0 => "_route"], "method", false, false, false, 145), [0 => "commande_index", 1 => "commande_new", 2 => "commande_show", 3 => "commande_edit", 4 => "commande_delete", 5 => "panier_index", 6 => "panier_new", 7 => "panier_show", 8 => "panier_edit", 9 => "panierdelete"])) {
            // line 156
            echo " active";
        }
        echo " treeview\">
                        <a href=\"#\">
                            <i class=\"fa fa-shopping-cart\"></i> <span>Gestion des Paniers</span>
                            <span class=\"pull-right-container\"><i class=\"fa fa-angle-left pull-right\"></i></span>
                        </a>
                        <ul class=\"treeview-menu\">
                            <li class=\"";
        // line 162
        if ((is_string($__internal_01c35b74bd85735098add188b3f8372ba465b232ab8298cb582c60f493d3c22e = twig_get_attribute($this->env, $this->source, twig_get_attribute($this->env, $this->source, twig_get_attribute($this->env, $this->source, (isset($context["app"]) || array_key_exists("app", $context) ? $context["app"] : (function () { throw new RuntimeError('Variable "app" does not exist.', 162, $this->source); })()), "request", [], "any", false, false, false, 162), "attributes", [], "any", false, false, false, 162), "get", [0 => "_route"], "method", false, false, false, 162)) && is_string($__internal_63ad1f9a2bf4db4af64b010785e9665558fdcac0e8db8b5b413ed986c62dbb52 = "commande") && ('' === $__internal_63ad1f9a2bf4db4af64b010785e9665558fdcac0e8db8b5b413ed986c62dbb52 || 0 === strpos($__internal_01c35b74bd85735098add188b3f8372ba465b232ab8298cb582c60f493d3c22e, $__internal_63ad1f9a2bf4db4af64b010785e9665558fdcac0e8db8b5b413ed986c62dbb52)))) {
            echo " active";
        }
        echo "\"><a href=\"/commande\"><i class=\"fa fa-circle-o\"></i> Commande</a></li>
                            <li class=\"";
        // line 163
        if ((is_string($__internal_f10a4cc339617934220127f034125576ed229e948660ebac906a15846d52f136 = twig_get_attribute($this->env, $this->source, twig_get_attribute($this->env, $this->source, twig_get_attribute($this->env, $this->source, (isset($context["app"]) || array_key_exists("app", $context) ? $context["app"] : (function () { throw new RuntimeError('Variable "app" does not exist.', 163, $this->source); })()), "request", [], "any", false, false, false, 163), "attributes", [], "any", false, false, false, 163), "get", [0 => "_route"], "method", false, false, false, 163)) && is_string($__internal_887a873a4dc3cf8bd4f99c487b4c7727999c350cc3a772414714e49a195e4386 = "panier") && ('' === $__internal_887a873a4dc3cf8bd4f99c487b4c7727999c350cc3a772414714e49a195e4386 || 0 === strpos($__internal_f10a4cc339617934220127f034125576ed229e948660ebac906a15846d52f136, $__internal_887a873a4dc3cf8bd4f99c487b4c7727999c350cc3a772414714e49a195e4386)))) {
            echo " active";
        }
        echo "\"><a href=\"/panier\"><i class=\"fa fa-circle-o\"></i>Panier</a></li>
                        </ul>
                    </li>
                    <li class=\"";
        // line 166
        if (twig_in_filter(twig_get_attribute($this->env, $this->source, twig_get_attribute($this->env, $this->source, twig_get_attribute($this->env, $this->source, (isset($context["app"]) || array_key_exists("app", $context) ? $context["app"] : (function () { throw new RuntimeError('Variable "app" does not exist.', 166, $this->source); })()), "request", [], "any", false, false, false, 166), "attributes", [], "any", false, false, false, 166), "get", [0 => "_route"], "method", false, false, false, 166), [0 => "aliment_index", 1 => "aliment_new", 2 => "aliment_show", 3 => "aliment_edit", 4 => "aliment_delete", 5 => "alimentassocie_index", 6 => "alimentassocie_new", 7 => "alimentassocie_show", 8 => "alimentassocie_edit", 9 => "alimentassocie_delete", 10 => "programmealimentaire_index", 11 => "programmealimentaire_new", 12 => "programmealimentaire_show", 13 => "programmealimentaire_edit", 14 => "programmealimentaire_delete"])) {
            // line 182
            echo " active";
        }
        echo " treeview\">
                        <a href=\"#\">
                            <i class=\"fa fa-cutlery\"></i> <span>Gestion de l'Alimentation</span>
                            <span class=\"pull-right-container\"><i class=\"fa fa-angle-left pull-right\"></i></span>
                        </a>
                        <ul class=\"treeview-menu\">
                            <li class=\"";
        // line 188
        if ((is_string($__internal_d527c24a729d38501d770b40a0d25e1ce8a7f0bff897cc4f8f449ba71fcff3d9 = twig_get_attribute($this->env, $this->source, twig_get_attribute($this->env, $this->source, twig_get_attribute($this->env, $this->source, (isset($context["app"]) || array_key_exists("app", $context) ? $context["app"] : (function () { throw new RuntimeError('Variable "app" does not exist.', 188, $this->source); })()), "request", [], "any", false, false, false, 188), "attributes", [], "any", false, false, false, 188), "get", [0 => "_route"], "method", false, false, false, 188)) && is_string($__internal_f6dde3a1020453fdf35e718e94f93ce8eb8803b28cc77a665308e14bbe8572ae = "aliment") && ('' === $__internal_f6dde3a1020453fdf35e718e94f93ce8eb8803b28cc77a665308e14bbe8572ae || 0 === strpos($__internal_d527c24a729d38501d770b40a0d25e1ce8a7f0bff897cc4f8f449ba71fcff3d9, $__internal_f6dde3a1020453fdf35e718e94f93ce8eb8803b28cc77a665308e14bbe8572ae)))) {
            echo " active";
        }
        echo "\"><a href=\"/aliment\"><i class=\"fa fa-circle-o\"></i> Aliments</a></li>
                            <li class=\"";
        // line 189
        if ((is_string($__internal_25c0fab8152b8dd6b90603159c0f2e8a936a09ab76edb5e4d7bc95d9a8d2dc8f = twig_get_attribute($this->env, $this->source, twig_get_attribute($this->env, $this->source, twig_get_attribute($this->env, $this->source, (isset($context["app"]) || array_key_exists("app", $context) ? $context["app"] : (function () { throw new RuntimeError('Variable "app" does not exist.', 189, $this->source); })()), "request", [], "any", false, false, false, 189), "attributes", [], "any", false, false, false, 189), "get", [0 => "_route"], "method", false, false, false, 189)) && is_string($__internal_f769f712f3484f00110c86425acea59f5af2752239e2e8596bcb6effeb425b40 = "alimentassocie") && ('' === $__internal_f769f712f3484f00110c86425acea59f5af2752239e2e8596bcb6effeb425b40 || 0 === strpos($__internal_25c0fab8152b8dd6b90603159c0f2e8a936a09ab76edb5e4d7bc95d9a8d2dc8f, $__internal_f769f712f3484f00110c86425acea59f5af2752239e2e8596bcb6effeb425b40)))) {
            echo " active";
        }
        echo "\"><a href=\"/alimentassocie\"><i class=\"fa fa-circle-o\"></i> Aliments Associés</a></li>
                            <li class=\"";
        // line 190
        if ((is_string($__internal_98e944456c0f58b2585e4aa36e3a7e43f4b7c9038088f0f056004af41f4a007f = twig_get_attribute($this->env, $this->source, twig_get_attribute($this->env, $this->source, twig_get_attribute($this->env, $this->source, (isset($context["app"]) || array_key_exists("app", $context) ? $context["app"] : (function () { throw new RuntimeError('Variable "app" does not exist.', 190, $this->source); })()), "request", [], "any", false, false, false, 190), "attributes", [], "any", false, false, false, 190), "get", [0 => "_route"], "method", false, false, false, 190)) && is_string($__internal_a06a70691a7ca361709a372174fa669f5ee1c1e4ed302b3a5b61c10c80c02760 = "programmealimentaire") && ('' === $__internal_a06a70691a7ca361709a372174fa669f5ee1c1e4ed302b3a5b61c10c80c02760 || 0 === strpos($__internal_98e944456c0f58b2585e4aa36e3a7e43f4b7c9038088f0f056004af41f4a007f, $__internal_a06a70691a7ca361709a372174fa669f5ee1c1e4ed302b3a5b61c10c80c02760)))) {
            echo " active";
        }
        echo "\"><a href=\"/programmealimentaire\"><i class=\"fa fa-circle-o\"></i> Programmes Alimentaires</a></li>
                        </ul>
                    </li>
                </ul>
            </section>
            <!-- /.sidebar -->
        </aside>
        <!-- Content Wrapper. Contains page content -->
        <div class=\"content-wrapper\">
            <section class=\"content-header\">
                <h1>
                    ";
        // line 201
        $this->displayBlock('header', $context, $blocks);
        // line 202
        echo "                    <small>Control panel</small>
                </h1>
                <ol class=\"breadcrumb\">
                    <li><a href=\"#\"><i class=\"fa fa-dashboard\"></i> Home</a></li>
                    <li class=\"active\">";
        // line 206
        $this->displayBlock('breadcrumb', $context, $blocks);
        echo "</li>
                </ol>
            </section>
            <!-- Main content -->
            <section class=\"content\">
                ";
        // line 211
        $this->displayBlock('body', $context, $blocks);
        // line 212
        echo "            </section>
        </div>
    </div>
    <!-- ./wrapper -->

    <!-- jQuery 3 -->
    <script src=\"/back/bower_components/jquery/dist/jquery.min.js\"></script>
    <!-- jQuery UI 1.11.4 -->
    <script src=\"/back/bower_components/jquery-ui/jquery-ui.min.js\"></script>
    <!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
    <script>
        \$.widget.bridge('uibutton', \$.ui.button);
    </script>
    <!-- Bootstrap 3.3.7 -->
    <script src=\"/back/bower_components/bootstrap/dist/js/bootstrap.min.js\"></script>
    <!-- Morris.js charts -->
    <script src=\"/back/bower_components/raphael/raphael.min.js\"></script>
    <script src=\"/back/bower_components/morris.js/morris.min.js\"></script>
    <!-- Sparkline -->
    <script src=\"/back/bower_components/jquery-sparkline/dist/jquery.sparkline.min.js\"></script>
    <!-- jvectormap -->
    <script src=\"/back/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js\"></script>
    <script src=\"/back/plugins/jvectormap/jquery-jvectormap-world-mill-en.js\"></script>
    <!-- jQuery Knob Chart -->
    <script src=\"/back/bower_components/jquery-knob/dist/jquery.knob.min.js\"></script>
    <!-- daterangepicker -->
    <script src=\"/back/bower_components/moment/min/moment.min.js\"></script>
    <script src=\"/back/bower_components/bootstrap-daterangepicker/daterangepicker.js\"></script>
    <!-- datepicker -->
    <script src=\"/back/bower_components/bootstrap-datepicker/dist/js/bootstrap-datepicker.min.js\"></script>
    <!-- Bootstrap WYSIHTML5 -->
    <script src=\"/back/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js\"></script>
    <!-- Slimscroll -->
    <script src=\"/back/bower_components/jquery-slimscroll/jquery.slimscroll.min.js\"></script>
    <!-- FastClick -->
    <script src=\"/back/bower_components/fastclick/lib/fastclick.js\"></script>
    <!-- AdminLTE App -->
    <script src=\"/back/dist/js/adminlte.min.js\"></script>
    <!-- AdminLTE dashboard demo (This is only for demo purposes) -->
    <script src=\"/back/dist/js/pages/dashboard.js\"></script>
    <!-- AdminLTE for demo purposes -->
    <script src=\"/back/dist/js/demo.js\"></script>
</body>
</html>
";
        
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e->leave($__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e_prof);

        
        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02->leave($__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02_prof);

    }

    // line 8
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

    // line 201
    public function block_header($context, array $blocks = [])
    {
        $macros = $this->macros;
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e = $this->extensions["Symfony\\Bundle\\WebProfilerBundle\\Twig\\WebProfilerExtension"];
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e->enter($__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "block", "header"));

        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02 = $this->extensions["Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension"];
        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02->enter($__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "block", "header"));

        echo "Welcome!";
        
        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02->leave($__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02_prof);

        
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e->leave($__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e_prof);

    }

    // line 206
    public function block_breadcrumb($context, array $blocks = [])
    {
        $macros = $this->macros;
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e = $this->extensions["Symfony\\Bundle\\WebProfilerBundle\\Twig\\WebProfilerExtension"];
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e->enter($__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "block", "breadcrumb"));

        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02 = $this->extensions["Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension"];
        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02->enter($__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02_prof = new \Twig\Profiler\Profile($this->getTemplateName(), "block", "breadcrumb"));

        
        $__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02->leave($__internal_319393461309892924ff6e74d6d6e64287df64b63545b994e100d4ab223aed02_prof);

        
        $__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e->leave($__internal_085b0142806202599c7fe3b329164a92397d8978207a37e79d70b8c52599e33e_prof);

    }

    // line 211
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
        return "back.html.twig";
    }

    public function isTraitable()
    {
        return false;
    }

    public function getDebugInfo()
    {
        return array (  396 => 211,  378 => 206,  359 => 201,  340 => 8,  286 => 212,  284 => 211,  276 => 206,  270 => 202,  268 => 201,  252 => 190,  246 => 189,  240 => 188,  230 => 182,  228 => 166,  220 => 163,  214 => 162,  204 => 156,  202 => 145,  194 => 142,  188 => 141,  182 => 140,  172 => 134,  170 => 118,  57 => 8,  49 => 2,  47 => 1,);
    }

    public function getSourceContext()
    {
        return new Source("{% set page = app.request.get('_route') %}

<!DOCTYPE html>
<html>
<head>
    <meta charset=\"utf-8\">
    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">
    <title>{% block title %}Welcome!{% endblock %}</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content=\"width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no\" name=\"viewport\">
    <!-- Bootstrap 3.3.7 -->
    <link rel=\"stylesheet\" href=\"/back/bower_components/bootstrap/dist/css/bootstrap.min.css\">
    <!-- Font Awesome -->
    <link rel=\"stylesheet\" href=\"/back/bower_components/font-awesome/css/font-awesome.min.css\">
    <!-- Ionicons -->
    <link rel=\"stylesheet\" href=\"/back/bower_components/Ionicons/css/ionicons.min.css\">
    <!-- Theme style -->
    <link rel=\"stylesheet\" href=\"/back/dist/css/AdminLTE.min.css\">
    <!-- AdminLTE Skins. Choose a skin from the css/skins
         folder instead of downloading all of them to reduce the load. -->
    <link rel=\"stylesheet\" href=\"/back/dist/css/skins/_all-skins.min.css\">
    <!-- Morris chart -->
    <link rel=\"stylesheet\" href=\"/back/bower_components/morris.js/morris.css\">
    <!-- jvectormap -->
    <link rel=\"stylesheet\" href=\"/back/bower_components/jvectormap/jquery-jvectormap.css\">
    <!-- Date Picker -->
    <link rel=\"stylesheet\" href=\"/back/bower_components/bootstrap-datepicker/dist/css/bootstrap-datepicker.min.css\">
    <!-- Daterange picker -->
    <link rel=\"stylesheet\" href=\"/back/bower_components/bootstrap-daterangepicker/daterangepicker.css\">
    <!-- bootstrap wysihtml5 - text editor -->
    <link rel=\"stylesheet\" href=\"/back/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css\">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src=\"https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js\"></script>
    <script src=\"https://oss.maxcdn.com/respond/1.4.2/respond.min.js\"></script>
    <![endif]-->

    <!-- Google Font -->
    <link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic\">
</head>
<body class=\"fixed hold-transition skin-purple-light sidebar-mini\">
    <div class=\"wrapper\">
        <header class=\"main-header\">
            <!-- Logo -->
            <a class=\"logo\">
                <!-- mini logo for sidebar mini 50x50 pixels -->
                <span class=\"logo-mini\"><b>e</b>IR</span>
                <!-- logo for regular state and mobile devices -->
                <span class=\"logo-lg\"><b>elix</b>IR</span>
            </a>
            <!-- Header Navbar: style can be found in header.less -->
            <nav class=\"navbar navbar-static-top\">
                <!-- Sidebar toggle button-->
                <a href=\"#\" class=\"sidebar-toggle\" data-toggle=\"push-menu\" role=\"button\">
                    <span class=\"sr-only\">Toggle navigation</span>
                </a>

                <div class=\"navbar-custom-menu\">
                    <ul class=\"nav navbar-nav\">
                        <li class=\"dropdown user user-menu\">
                            <a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\">
                                <img src=\"dist/img/user2-160x160.jpg\" class=\"user-image\" alt=\"User Image\">
                                <span class=\"hidden-xs\">Alexander Pierce</span>
                            </a>
                            <ul class=\"dropdown-menu\">
                                <!-- User image -->
                                <li class=\"user-header\">
                                    <img src=\"dist/img/user2-160x160.jpg\" class=\"img-circle\" alt=\"User Image\">

                                    <p>
                                        Alexander Pierce - Web Developer
                                        <small>Member since Nov. 2012</small>
                                    </p>
                                </li>
                                <!-- Menu Body -->
                                <li class=\"user-body\">
                                    <div class=\"row\">
                                        <div class=\"col-xs-4 text-center\">
                                            <a href=\"#\">Followers</a>
                                        </div>
                                        <div class=\"col-xs-4 text-center\">
                                            <a href=\"#\">Sales</a>
                                        </div>
                                        <div class=\"col-xs-4 text-center\">
                                            <a href=\"#\">Friends</a>
                                        </div>
                                    </div>
                                    <!-- /.row -->
                                </li>
                                <!-- Menu Footer-->
                                <li class=\"user-footer\">
                                    <div class=\"pull-left\">
                                        <a href=\"#\" class=\"btn btn-default btn-flat\">Profile</a>
                                    </div>
                                    <div class=\"pull-right\">
                                        <a href=\"#\" class=\"btn btn-default btn-flat\">Sign out</a>
                                    </div>
                                </li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </nav>
        </header>

        <aside class=\"main-sidebar\">
            <!-- sidebar: style can be found in sidebar.less -->
            <section class=\"sidebar\">
                <ul class=\"sidebar-menu\" data-widget=\"tree\">
                    <li class=\"header\">MAIN NAVIGATION</li>
                    <li>
                        <a href=\"/\">
                            <i class=\"fa fa-dashboard\"></i> <span>Dashboard</span>
                        </a>
                    </li>
                    <li class=\"{% if app.request.attributes.get('_route') in [
                        'categorie_index',
                        'categorie_new',
                        'categorie_show',
                        'categorie_edit',
                        'categorie_delete',
                        'produit_index',
                        'produit_new',
                        'produit_show',
                        'produit_edit',
                        'produit_delete',
                        'evaluation_index',
                        'evaluation_new',
                        'evaluation_show',
                        'evaluation_edit',
                        'evaluation_delete',
                    ] %} active{% endif %} treeview\">
                        <a href=\"#\">
                            <i class=\"fa fa-book\"></i> <span>Gestion des Produits</span>
                            <span class=\"pull-right-container\"><i class=\"fa fa-angle-left pull-right\"></i></span>
                        </a>
                        <ul class=\"treeview-menu\">
                            <li class=\"{% if app.request.attributes.get( '_route' ) starts with 'categorie' %} active{% endif %}\"><a href=\"/categorie\"><i class=\"fa fa-circle-o\"></i> Categorie</a></li>
                            <li class=\"{% if app.request.attributes.get( '_route' ) starts with 'produit' %} active{% endif %}\"><a href=\"/produit\"><i class=\"fa fa-circle-o\"></i>Produit</a></li>
                            <li class=\"{% if app.request.attributes.get( '_route' ) starts with 'evaluation' %} active{% endif %}\"><a href=\"/evaluation\"><i class=\"fa fa-circle-o\"></i>Evaluation</a></li>
                        </ul>
                    </li>
                    <li class=\"{% if app.request.attributes.get('_route') in [
                        'commande_index',
                        'commande_new',
                        'commande_show',
                        'commande_edit',
                        'commande_delete',
                        'panier_index',
                        'panier_new',
                        'panier_show',
                        'panier_edit',
                        'panierdelete',
                    ] %} active{% endif %} treeview\">
                        <a href=\"#\">
                            <i class=\"fa fa-shopping-cart\"></i> <span>Gestion des Paniers</span>
                            <span class=\"pull-right-container\"><i class=\"fa fa-angle-left pull-right\"></i></span>
                        </a>
                        <ul class=\"treeview-menu\">
                            <li class=\"{% if app.request.attributes.get( '_route' ) starts with 'commande' %} active{% endif %}\"><a href=\"/commande\"><i class=\"fa fa-circle-o\"></i> Commande</a></li>
                            <li class=\"{% if app.request.attributes.get( '_route' ) starts with 'panier' %} active{% endif %}\"><a href=\"/panier\"><i class=\"fa fa-circle-o\"></i>Panier</a></li>
                        </ul>
                    </li>
                    <li class=\"{% if app.request.attributes.get('_route') in [
                        'aliment_index',
                        'aliment_new',
                        'aliment_show',
                        'aliment_edit',
                        'aliment_delete',
                        'alimentassocie_index',
                        'alimentassocie_new',
                        'alimentassocie_show',
                        'alimentassocie_edit',
                        'alimentassocie_delete',
                        'programmealimentaire_index',
                        'programmealimentaire_new',
                        'programmealimentaire_show',
                        'programmealimentaire_edit',
                        'programmealimentaire_delete',
                    ] %} active{% endif %} treeview\">
                        <a href=\"#\">
                            <i class=\"fa fa-cutlery\"></i> <span>Gestion de l'Alimentation</span>
                            <span class=\"pull-right-container\"><i class=\"fa fa-angle-left pull-right\"></i></span>
                        </a>
                        <ul class=\"treeview-menu\">
                            <li class=\"{% if app.request.attributes.get( '_route' ) starts with 'aliment' %} active{% endif %}\"><a href=\"/aliment\"><i class=\"fa fa-circle-o\"></i> Aliments</a></li>
                            <li class=\"{% if app.request.attributes.get( '_route' ) starts with \"alimentassocie\" %} active{% endif %}\"><a href=\"/alimentassocie\"><i class=\"fa fa-circle-o\"></i> Aliments Associés</a></li>
                            <li class=\"{% if app.request.attributes.get( '_route' ) starts with 'programmealimentaire' %} active{% endif %}\"><a href=\"/programmealimentaire\"><i class=\"fa fa-circle-o\"></i> Programmes Alimentaires</a></li>
                        </ul>
                    </li>
                </ul>
            </section>
            <!-- /.sidebar -->
        </aside>
        <!-- Content Wrapper. Contains page content -->
        <div class=\"content-wrapper\">
            <section class=\"content-header\">
                <h1>
                    {% block header %}Welcome!{% endblock %}
                    <small>Control panel</small>
                </h1>
                <ol class=\"breadcrumb\">
                    <li><a href=\"#\"><i class=\"fa fa-dashboard\"></i> Home</a></li>
                    <li class=\"active\">{% block breadcrumb %}{% endblock %}</li>
                </ol>
            </section>
            <!-- Main content -->
            <section class=\"content\">
                {% block body %}{% endblock %}
            </section>
        </div>
    </div>
    <!-- ./wrapper -->

    <!-- jQuery 3 -->
    <script src=\"/back/bower_components/jquery/dist/jquery.min.js\"></script>
    <!-- jQuery UI 1.11.4 -->
    <script src=\"/back/bower_components/jquery-ui/jquery-ui.min.js\"></script>
    <!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
    <script>
        \$.widget.bridge('uibutton', \$.ui.button);
    </script>
    <!-- Bootstrap 3.3.7 -->
    <script src=\"/back/bower_components/bootstrap/dist/js/bootstrap.min.js\"></script>
    <!-- Morris.js charts -->
    <script src=\"/back/bower_components/raphael/raphael.min.js\"></script>
    <script src=\"/back/bower_components/morris.js/morris.min.js\"></script>
    <!-- Sparkline -->
    <script src=\"/back/bower_components/jquery-sparkline/dist/jquery.sparkline.min.js\"></script>
    <!-- jvectormap -->
    <script src=\"/back/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js\"></script>
    <script src=\"/back/plugins/jvectormap/jquery-jvectormap-world-mill-en.js\"></script>
    <!-- jQuery Knob Chart -->
    <script src=\"/back/bower_components/jquery-knob/dist/jquery.knob.min.js\"></script>
    <!-- daterangepicker -->
    <script src=\"/back/bower_components/moment/min/moment.min.js\"></script>
    <script src=\"/back/bower_components/bootstrap-daterangepicker/daterangepicker.js\"></script>
    <!-- datepicker -->
    <script src=\"/back/bower_components/bootstrap-datepicker/dist/js/bootstrap-datepicker.min.js\"></script>
    <!-- Bootstrap WYSIHTML5 -->
    <script src=\"/back/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js\"></script>
    <!-- Slimscroll -->
    <script src=\"/back/bower_components/jquery-slimscroll/jquery.slimscroll.min.js\"></script>
    <!-- FastClick -->
    <script src=\"/back/bower_components/fastclick/lib/fastclick.js\"></script>
    <!-- AdminLTE App -->
    <script src=\"/back/dist/js/adminlte.min.js\"></script>
    <!-- AdminLTE dashboard demo (This is only for demo purposes) -->
    <script src=\"/back/dist/js/pages/dashboard.js\"></script>
    <!-- AdminLTE for demo purposes -->
    <script src=\"/back/dist/js/demo.js\"></script>
</body>
</html>
", "back.html.twig", "C:\\wamp64\\www\\pidev\\templates\\back.html.twig");
    }
}
