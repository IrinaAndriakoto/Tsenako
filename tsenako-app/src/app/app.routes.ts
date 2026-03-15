import { Routes } from '@angular/router';
import { ListeProduitsComponent } from './pages/liste-produits/liste-produits.component';

export const routes: Routes = [
    { path: '', redirectTo: '/liste-produits', pathMatch: 'full' },
    { path: 'liste-produits', component: ListeProduitsComponent }
];
