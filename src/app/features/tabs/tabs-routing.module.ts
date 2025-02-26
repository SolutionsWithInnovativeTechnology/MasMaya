import { RouterModule, Routes } from '@angular/router';
import { TabsPage } from './tabs.page';
import { NgModule } from '@angular/core';

export const routes: Routes = [
  {
    path: 'tabs',
    component: TabsPage,
    children: [
      {
        path: 'historia',
        loadComponent: () =>
          import('../historia/historia.page').then((m) => m.HistoriaPage),
        
      },
      {
        path: 'juegos',
        children: [
          {
            path: '',
            loadComponent: () =>
              import('../juegos/juegos.page').then((m) => m.JuegosPage),
          },
          {
            path: 'numeros',
            loadComponent: () =>
              import('../juegos/numeros/numeros.page').then((m) => m.NumerosPage),
          },
          {
            path: 'frutas',
            loadComponent: () =>
              import('../juegos/frutas/frutas.page').then((m) => m.FrutasPage),
          },
          {
            path: 'frases',
            loadComponent: () =>
              import('../juegos/frases/frases.page').then((m) => m.FrasesPage),
          },
          {
            path: 'animales',
            loadComponent: () =>
              import('../juegos/animales/animales.page').then((m) => m.AnimalesPage),
          },
        ]
      },
      {
        path: 'clasificacion',
        loadComponent: () =>
          import('../clasificacion/clasificacion.page').then((m) => m.ClasificacionPage),
        
      },
      {
        path: '',
        redirectTo: '/tabs/historia',
        pathMatch: 'full',
      },
    ],
  },
  {
    path: '',
    redirectTo: '/tabs/historia',
    pathMatch: 'full',
  },
];
@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class TabsPageRoutingModule {}
