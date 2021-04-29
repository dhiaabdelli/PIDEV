<?php

/**
 * This file has been auto-generated
 * by the Symfony Routing Component.
 */

return [
    false, // $matchHost
    [ // $staticRoutes
        '/_profiler' => [[['_route' => '_profiler_home', '_controller' => 'web_profiler.controller.profiler::homeAction'], null, null, null, true, false, null]],
        '/_profiler/search' => [[['_route' => '_profiler_search', '_controller' => 'web_profiler.controller.profiler::searchAction'], null, null, null, false, false, null]],
        '/_profiler/search_bar' => [[['_route' => '_profiler_search_bar', '_controller' => 'web_profiler.controller.profiler::searchBarAction'], null, null, null, false, false, null]],
        '/_profiler/phpinfo' => [[['_route' => '_profiler_phpinfo', '_controller' => 'web_profiler.controller.profiler::phpinfoAction'], null, null, null, false, false, null]],
        '/_profiler/open' => [[['_route' => '_profiler_open_file', '_controller' => 'web_profiler.controller.profiler::openAction'], null, null, null, false, false, null]],
        '/aliment' => [[['_route' => 'aliment_index', '_controller' => 'App\\Controller\\AlimentController::index'], null, ['GET' => 0], null, true, false, null]],
        '/aliment/new' => [[['_route' => 'aliment_new', '_controller' => 'App\\Controller\\AlimentController::new'], null, ['GET' => 0, 'POST' => 1], null, false, false, null]],
        '/alimentassocie' => [[['_route' => 'alimentassocie_index', '_controller' => 'App\\Controller\\AlimentassocieController::index'], null, ['GET' => 0], null, true, false, null]],
        '/alimentassocie/new' => [[['_route' => 'alimentassocie_new', '_controller' => 'App\\Controller\\AlimentassocieController::new'], null, ['GET' => 0, 'POST' => 1], null, false, false, null]],
        '/categorie' => [[['_route' => 'categorie_index', '_controller' => 'App\\Controller\\CategorieController::index'], null, ['GET' => 0], null, true, false, null]],
        '/categorie/new' => [[['_route' => 'categorie_new', '_controller' => 'App\\Controller\\CategorieController::new'], null, ['GET' => 0, 'POST' => 1], null, false, false, null]],
        '/commande' => [[['_route' => 'commande_index', '_controller' => 'App\\Controller\\CommandeController::index'], null, ['GET' => 0], null, true, false, null]],
        '/commande/new' => [[['_route' => 'commande_new', '_controller' => 'App\\Controller\\CommandeController::new'], null, ['GET' => 0, 'POST' => 1], null, false, false, null]],
        '/compte' => [[['_route' => 'compte_index', '_controller' => 'App\\Controller\\CompteController::index'], null, ['GET' => 0], null, true, false, null]],
        '/compte/new' => [[['_route' => 'compte_new', '_controller' => 'App\\Controller\\CompteController::new'], null, ['GET' => 0, 'POST' => 1], null, false, false, null]],
        '/evaluation' => [[['_route' => 'evaluation_index', '_controller' => 'App\\Controller\\EvaluationController::index'], null, ['GET' => 0], null, true, false, null]],
        '/evaluation/new' => [[['_route' => 'evaluation_new', '_controller' => 'App\\Controller\\EvaluationController::new'], null, ['GET' => 0, 'POST' => 1], null, false, false, null]],
        '/exercice' => [[['_route' => 'exercice_index', '_controller' => 'App\\Controller\\ExerciceController::index'], null, ['GET' => 0], null, true, false, null]],
        '/exercice/new' => [[['_route' => 'exercice_new', '_controller' => 'App\\Controller\\ExerciceController::new'], null, ['GET' => 0, 'POST' => 1], null, false, false, null]],
        '/exerciceassocie' => [[['_route' => 'exerciceassocie_index', '_controller' => 'App\\Controller\\ExerciceassocieController::index'], null, ['GET' => 0], null, true, false, null]],
        '/exerciceassocie/new' => [[['_route' => 'exerciceassocie_new', '_controller' => 'App\\Controller\\ExerciceassocieController::new'], null, ['GET' => 0, 'POST' => 1], null, false, false, null]],
        '/shop' => [[['_route' => 'shop', '_controller' => 'App\\Controller\\FrontController::index'], null, null, null, false, false, null]],
        '/progalim' => [[['_route' => 'progalim', '_controller' => 'App\\Controller\\FrontController::progalim'], null, null, null, false, false, null]],
        '/livraison' => [[['_route' => 'livraison_index', '_controller' => 'App\\Controller\\LivraisonController::index'], null, ['GET' => 0], null, true, false, null]],
        '/livraison/new' => [[['_route' => 'livraison_new', '_controller' => 'App\\Controller\\LivraisonController::new'], null, ['GET' => 0, 'POST' => 1], null, false, false, null]],
        '/livreur' => [[['_route' => 'livreur_index', '_controller' => 'App\\Controller\\LivreurController::index'], null, ['GET' => 0], null, true, false, null]],
        '/livreur/new' => [[['_route' => 'livreur_new', '_controller' => 'App\\Controller\\LivreurController::new'], null, ['GET' => 0, 'POST' => 1], null, false, false, null]],
        '/panier' => [[['_route' => 'panier_index', '_controller' => 'App\\Controller\\PanierController::index'], null, ['GET' => 0], null, true, false, null]],
        '/panier/new' => [[['_route' => 'panier_new', '_controller' => 'App\\Controller\\PanierController::new'], null, ['GET' => 0, 'POST' => 1], null, false, false, null]],
        '/produit' => [[['_route' => 'produit_index', '_controller' => 'App\\Controller\\ProduitController::index'], null, ['GET' => 0], null, true, false, null]],
        '/produit/new' => [[['_route' => 'produit_new', '_controller' => 'App\\Controller\\ProduitController::new'], null, ['GET' => 0, 'POST' => 1], null, false, false, null]],
        '/produitscommand' => [[['_route' => 'produitscommand_index', '_controller' => 'App\\Controller\\ProduitscommandController::index'], null, ['GET' => 0], null, true, false, null]],
        '/produitscommand/new' => [[['_route' => 'produitscommand_new', '_controller' => 'App\\Controller\\ProduitscommandController::new'], null, ['GET' => 0, 'POST' => 1], null, false, false, null]],
        '/profile' => [[['_route' => 'profile_index', '_controller' => 'App\\Controller\\ProfileController::index'], null, ['GET' => 0], null, true, false, null]],
        '/profile/new' => [[['_route' => 'profile_new', '_controller' => 'App\\Controller\\ProfileController::new'], null, ['GET' => 0, 'POST' => 1], null, false, false, null]],
        '/programmealimentaire' => [[['_route' => 'programmealimentaire_index', '_controller' => 'App\\Controller\\ProgrammealimentaireController::index'], null, ['GET' => 0], null, true, false, null]],
        '/programmealimentaire/new' => [[['_route' => 'programmealimentaire_new', '_controller' => 'App\\Controller\\ProgrammealimentaireController::new'], null, ['GET' => 0, 'POST' => 1], null, false, false, null]],
    ],
    [ // $regexpList
        0 => '{^(?'
                .'|/_(?'
                    .'|error/(\\d+)(?:\\.([^/]++))?(*:38)'
                    .'|wdt/([^/]++)(*:57)'
                    .'|profiler/([^/]++)(?'
                        .'|/(?'
                            .'|search/results(*:102)'
                            .'|router(*:116)'
                            .'|exception(?'
                                .'|(*:136)'
                                .'|\\.css(*:149)'
                            .')'
                        .')'
                        .'|(*:159)'
                    .')'
                .')'
                .'|/aliment(?'
                    .'|/([^/]++)(?'
                        .'|(*:192)'
                        .'|/edit(*:205)'
                        .'|(*:213)'
                    .')'
                    .'|associe/(?'
                        .'|([^/]++)(?'
                            .'|(*:244)'
                            .'|/edit(*:257)'
                            .'|(*:265)'
                        .')'
                        .'|associerAliments/([^/]++)(*:299)'
                    .')'
                .')'
                .'|/c(?'
                    .'|ategorie/([^/]++)(?'
                        .'|(*:334)'
                        .'|/edit(*:347)'
                        .'|(*:355)'
                    .')'
                    .'|om(?'
                        .'|mande/([^/]++)(?'
                            .'|(*:386)'
                            .'|/edit(*:399)'
                            .'|(*:407)'
                        .')'
                        .'|pte/([^/]++)(?'
                            .'|(*:431)'
                            .'|/edit(*:444)'
                            .'|(*:452)'
                        .')'
                    .')'
                .')'
                .'|/e(?'
                    .'|valuation/([^/]++)(?'
                        .'|(*:489)'
                        .'|/edit(*:502)'
                        .'|(*:510)'
                    .')'
                    .'|xercice(?'
                        .'|/([^/]++)(?'
                            .'|(*:541)'
                            .'|/edit(*:554)'
                            .'|(*:562)'
                        .')'
                        .'|associe/([^/]++)(?'
                            .'|(*:590)'
                            .'|/edit(*:603)'
                            .'|(*:611)'
                        .')'
                    .')'
                .')'
                .'|/shop/([^/]++)(*:636)'
                .'|/livr(?'
                    .'|aison/([^/]++)(?'
                        .'|(*:669)'
                        .'|/edit(*:682)'
                        .'|(*:690)'
                    .')'
                    .'|eur/([^/]++)(?'
                        .'|(*:714)'
                        .'|/edit(*:727)'
                        .'|(*:735)'
                    .')'
                .')'
                .'|/p(?'
                    .'|anier/([^/]++)(?'
                        .'|(*:767)'
                        .'|/edit(*:780)'
                        .'|(*:788)'
                    .')'
                    .'|ro(?'
                        .'|duit(?'
                            .'|/([^/]++)(?'
                                .'|(*:821)'
                                .'|/edit(*:834)'
                                .'|(*:842)'
                            .')'
                            .'|scommand/([^/]++)(?'
                                .'|(*:871)'
                                .'|/edit(*:884)'
                                .'|(*:892)'
                            .')'
                        .')'
                        .'|file/([^/]++)(?'
                            .'|(*:918)'
                            .'|/edit(*:931)'
                            .'|(*:939)'
                        .')'
                        .'|grammealimentaire/(?'
                            .'|([^/]++)(?'
                                .'|(*:980)'
                                .'|/edit(*:993)'
                                .'|(*:1001)'
                            .')'
                            .'|calculerProgrammeAlimentaire/([^/]++)(*:1048)'
                        .')'
                    .')'
                .')'
            .')/?$}sD',
    ],
    [ // $dynamicRoutes
        38 => [[['_route' => '_preview_error', '_controller' => 'error_controller::preview', '_format' => 'html'], ['code', '_format'], null, null, false, true, null]],
        57 => [[['_route' => '_wdt', '_controller' => 'web_profiler.controller.profiler::toolbarAction'], ['token'], null, null, false, true, null]],
        102 => [[['_route' => '_profiler_search_results', '_controller' => 'web_profiler.controller.profiler::searchResultsAction'], ['token'], null, null, false, false, null]],
        116 => [[['_route' => '_profiler_router', '_controller' => 'web_profiler.controller.router::panelAction'], ['token'], null, null, false, false, null]],
        136 => [[['_route' => '_profiler_exception', '_controller' => 'web_profiler.controller.exception_panel::body'], ['token'], null, null, false, false, null]],
        149 => [[['_route' => '_profiler_exception_css', '_controller' => 'web_profiler.controller.exception_panel::stylesheet'], ['token'], null, null, false, false, null]],
        159 => [[['_route' => '_profiler', '_controller' => 'web_profiler.controller.profiler::panelAction'], ['token'], null, null, false, true, null]],
        192 => [[['_route' => 'aliment_show', '_controller' => 'App\\Controller\\AlimentController::show'], ['id'], ['GET' => 0], null, false, true, null]],
        205 => [[['_route' => 'aliment_edit', '_controller' => 'App\\Controller\\AlimentController::edit'], ['id'], ['GET' => 0, 'POST' => 1], null, false, false, null]],
        213 => [[['_route' => 'aliment_delete', '_controller' => 'App\\Controller\\AlimentController::delete'], ['id'], ['POST' => 0], null, false, true, null]],
        244 => [[['_route' => 'alimentassocie_show', '_controller' => 'App\\Controller\\AlimentassocieController::show'], ['id'], ['GET' => 0], null, false, true, null]],
        257 => [[['_route' => 'alimentassocie_edit', '_controller' => 'App\\Controller\\AlimentassocieController::edit'], ['id'], ['GET' => 0, 'POST' => 1], null, false, false, null]],
        265 => [[['_route' => 'alimentassocie_delete', '_controller' => 'App\\Controller\\AlimentassocieController::delete'], ['id'], ['POST' => 0], null, false, true, null]],
        299 => [[['_route' => 'associerAliments', '_controller' => 'App\\Controller\\AlimentassocieController::associerAliments'], ['idp'], ['GET' => 0, 'POST' => 1], null, false, true, null]],
        334 => [[['_route' => 'categorie_show', '_controller' => 'App\\Controller\\CategorieController::show'], ['id'], ['GET' => 0], null, false, true, null]],
        347 => [[['_route' => 'categorie_edit', '_controller' => 'App\\Controller\\CategorieController::edit'], ['id'], ['GET' => 0, 'POST' => 1], null, false, false, null]],
        355 => [[['_route' => 'categorie_delete', '_controller' => 'App\\Controller\\CategorieController::delete'], ['id'], ['POST' => 0], null, false, true, null]],
        386 => [[['_route' => 'commande_show', '_controller' => 'App\\Controller\\CommandeController::show'], ['id'], ['GET' => 0], null, false, true, null]],
        399 => [[['_route' => 'commande_edit', '_controller' => 'App\\Controller\\CommandeController::edit'], ['id'], ['GET' => 0, 'POST' => 1], null, false, false, null]],
        407 => [[['_route' => 'commande_delete', '_controller' => 'App\\Controller\\CommandeController::delete'], ['id'], ['POST' => 0], null, false, true, null]],
        431 => [[['_route' => 'compte_show', '_controller' => 'App\\Controller\\CompteController::show'], ['email'], ['GET' => 0], null, false, true, null]],
        444 => [[['_route' => 'compte_edit', '_controller' => 'App\\Controller\\CompteController::edit'], ['email'], ['GET' => 0, 'POST' => 1], null, false, false, null]],
        452 => [[['_route' => 'compte_delete', '_controller' => 'App\\Controller\\CompteController::delete'], ['email'], ['POST' => 0], null, false, true, null]],
        489 => [[['_route' => 'evaluation_show', '_controller' => 'App\\Controller\\EvaluationController::show'], ['id'], ['GET' => 0], null, false, true, null]],
        502 => [[['_route' => 'evaluation_edit', '_controller' => 'App\\Controller\\EvaluationController::edit'], ['id'], ['GET' => 0, 'POST' => 1], null, false, false, null]],
        510 => [[['_route' => 'evaluation_delete', '_controller' => 'App\\Controller\\EvaluationController::delete'], ['id'], ['POST' => 0], null, false, true, null]],
        541 => [[['_route' => 'exercice_show', '_controller' => 'App\\Controller\\ExerciceController::show'], ['id'], ['GET' => 0], null, false, true, null]],
        554 => [[['_route' => 'exercice_edit', '_controller' => 'App\\Controller\\ExerciceController::edit'], ['id'], ['GET' => 0, 'POST' => 1], null, false, false, null]],
        562 => [[['_route' => 'exercice_delete', '_controller' => 'App\\Controller\\ExerciceController::delete'], ['id'], ['POST' => 0], null, false, true, null]],
        590 => [[['_route' => 'exerciceassocie_show', '_controller' => 'App\\Controller\\ExerciceassocieController::show'], ['idexassocier'], ['GET' => 0], null, false, true, null]],
        603 => [[['_route' => 'exerciceassocie_edit', '_controller' => 'App\\Controller\\ExerciceassocieController::edit'], ['idexassocier'], ['GET' => 0, 'POST' => 1], null, false, false, null]],
        611 => [[['_route' => 'exerciceassocie_delete', '_controller' => 'App\\Controller\\ExerciceassocieController::delete'], ['idexassocier'], ['POST' => 0], null, false, true, null]],
        636 => [[['_route' => 'shop_showcat', '_controller' => 'App\\Controller\\FrontController::show'], ['id'], ['GET' => 0], null, false, true, null]],
        669 => [[['_route' => 'livraison_show', '_controller' => 'App\\Controller\\LivraisonController::show'], ['idlivraison'], ['GET' => 0], null, false, true, null]],
        682 => [[['_route' => 'livraison_edit', '_controller' => 'App\\Controller\\LivraisonController::edit'], ['idlivraison'], ['GET' => 0, 'POST' => 1], null, false, false, null]],
        690 => [[['_route' => 'livraison_delete', '_controller' => 'App\\Controller\\LivraisonController::delete'], ['idlivraison'], ['POST' => 0], null, false, true, null]],
        714 => [[['_route' => 'livreur_show', '_controller' => 'App\\Controller\\LivreurController::show'], ['id'], ['GET' => 0], null, false, true, null]],
        727 => [[['_route' => 'livreur_edit', '_controller' => 'App\\Controller\\LivreurController::edit'], ['id'], ['GET' => 0, 'POST' => 1], null, false, false, null]],
        735 => [[['_route' => 'livreur_delete', '_controller' => 'App\\Controller\\LivreurController::delete'], ['id'], ['POST' => 0], null, false, true, null]],
        767 => [[['_route' => 'panier_show', '_controller' => 'App\\Controller\\PanierController::show'], ['idproduit'], ['GET' => 0], null, false, true, null]],
        780 => [[['_route' => 'panier_edit', '_controller' => 'App\\Controller\\PanierController::edit'], ['idproduit'], ['GET' => 0, 'POST' => 1], null, false, false, null]],
        788 => [[['_route' => 'panier_delete', '_controller' => 'App\\Controller\\PanierController::delete'], ['idproduit'], ['POST' => 0], null, false, true, null]],
        821 => [[['_route' => 'produit_show', '_controller' => 'App\\Controller\\ProduitController::show'], ['id'], ['GET' => 0], null, false, true, null]],
        834 => [[['_route' => 'produit_edit', '_controller' => 'App\\Controller\\ProduitController::edit'], ['id'], ['GET' => 0, 'POST' => 1], null, false, false, null]],
        842 => [[['_route' => 'produit_delete', '_controller' => 'App\\Controller\\ProduitController::delete'], ['id'], ['POST' => 0], null, false, true, null]],
        871 => [[['_route' => 'produitscommand_show', '_controller' => 'App\\Controller\\ProduitscommandController::show'], ['id'], ['GET' => 0], null, false, true, null]],
        884 => [[['_route' => 'produitscommand_edit', '_controller' => 'App\\Controller\\ProduitscommandController::edit'], ['id'], ['GET' => 0, 'POST' => 1], null, false, false, null]],
        892 => [[['_route' => 'produitscommand_delete', '_controller' => 'App\\Controller\\ProduitscommandController::delete'], ['id'], ['POST' => 0], null, false, true, null]],
        918 => [[['_route' => 'profile_show', '_controller' => 'App\\Controller\\ProfileController::show'], ['id'], ['GET' => 0], null, false, true, null]],
        931 => [[['_route' => 'profile_edit', '_controller' => 'App\\Controller\\ProfileController::edit'], ['id'], ['GET' => 0, 'POST' => 1], null, false, false, null]],
        939 => [[['_route' => 'profile_delete', '_controller' => 'App\\Controller\\ProfileController::delete'], ['id'], ['POST' => 0], null, false, true, null]],
        980 => [[['_route' => 'programmealimentaire_show', '_controller' => 'App\\Controller\\ProgrammealimentaireController::show'], ['idprofile'], ['GET' => 0], null, false, true, null]],
        993 => [[['_route' => 'programmealimentaire_edit', '_controller' => 'App\\Controller\\ProgrammealimentaireController::edit'], ['idprofile'], ['GET' => 0, 'POST' => 1], null, false, false, null]],
        1001 => [[['_route' => 'programmealimentaire_delete', '_controller' => 'App\\Controller\\ProgrammealimentaireController::delete'], ['idprofile'], ['POST' => 0], null, false, true, null]],
        1048 => [
            [['_route' => 'calculerProgrammeAlimentaire', '_controller' => 'App\\Controller\\ProgrammealimentaireController::calculerProgrammeAlimentaire'], ['idp'], ['GET' => 0, 'POST' => 1], null, false, true, null],
            [null, null, null, null, false, false, 0],
        ],
    ],
    null, // $checkCondition
];
