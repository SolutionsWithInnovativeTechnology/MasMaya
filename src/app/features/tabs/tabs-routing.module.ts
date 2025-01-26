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
        loadComponent: () =>
          import('../juegos/juegos.page').then((m) => m.JuegosPage),
        
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
