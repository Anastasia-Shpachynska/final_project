import { Routes } from '@angular/router';

export const APP_ROUTES: Routes = [
  {
    path: '',
    redirectTo: 'plp',
    pathMatch: 'full'
  },
  {
    path: 'plp',
    pathMatch: 'prefix',
    loadChildren:() => import('./pages/plp/plp.routes').then(r => r.PLP_ROUTES)
  }
];
