import { Routes } from '@angular/router';
import { HomepageComponent } from './pages/homepage/homepage.component';
import { ListeProduitsComponent } from './pages/liste-produits/liste-produits.component';

export const routes: Routes = [
    { path: '', redirectTo: '/accueil', pathMatch: 'full' },
    { path: 'accueil', component: HomepageComponent },
    { path: 'liste-produits', component: ListeProduitsComponent }
];
