import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

export const routes: Routes = [
  {
    path: '',
    loadChildren: () => import('./features/tabs/tabs.module').then((m) => m.TabsModule),
  },
  {
    path: '**',
    redirectTo: '',
    pathMatch: 'full',
  },
  {
    path: 'numeros',
    loadComponent: () => import('./features/juegos/numeros/numeros.page').then( m => m.NumerosPage)
  },
  {
    path: 'animales',
    loadComponent: () => import('./features/juegos/animales/animales.page').then( m => m.AnimalesPage)
  },
  {
    path: 'frases',
    loadComponent: () => import('./features/juegos/frases/frases.page').then( m => m.FrasesPage)
  },
  {
    path: 'frutas',
    loadComponent: () => import('./features/juegos/frutas/frutas.page').then( m => m.FrutasPage)
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}