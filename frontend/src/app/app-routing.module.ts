import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HelloComponent } from '../app/hello/hello.component';
import { WorksComponent } from '../app/works/works.component';

const routes: Routes = [
  { path: 'hello', component: HelloComponent },
  { path: 'work', component: WorksComponent },
  { path: '', redirectTo: '/hello', pathMatch: 'full' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
