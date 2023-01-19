import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {HomeComponent} from "./home/home.component";
import {AccountComponent} from "./account/account.component";
import {AdministratorAccountComponent} from "./account/administrator-account/administrator-account.component";
import {TeacherAccountComponent} from "./account/teacher-account/teacher-account.component";
import {LearnerAccountComponent} from "./account/learner-account/learner-account.component";
import {InscriptionComponent} from "./inscription/inscription.component";
import {
  InscriptionFormateurComponent
} from "./inscription/inscription-formateur.component/inscription-formateur.component";
import {ConnectionComponent} from "./connection/connection.component";
import {TrainingFieldComponent} from "./training-field/training-field.component";
import {ContactComponent} from "./contact/contact.component";
import {ProgrammingLangagesComponent} from "./training-field/programming-langages/programming-langages.component";
import {ReseauxComponent} from "./training-field/reseaux/reseaux.component";
import {GestionProjetComponent} from "./training-field/gestion-projet/gestion-projet.component";
import {SystemesExploitationComponent} from "./training-field/systemes-exploitation/systemes-exploitation.component";
import {
  ProgrammingLangagesItemComponent
} from "./training-field/programming-langages/programming-langages-item/programming-langages-item.component";
import {ProfileComponent} from "./account/profile/profile.component";
import {FormationsComponent} from "./account/administrator-account/formations/formations.component";
import {
  DomainesFormationComponent
} from "./account/administrator-account/domaines-formation/domaines-formation.component";

const routes: Routes = [
  {path: 'home', component: HomeComponent},
  {path: 'inscription', component: InscriptionComponent},
  {path: 'inscription-formateur', component: InscriptionFormateurComponent},
  {path: 'connection', component: ConnectionComponent},
  {
    path: 'account', component: AccountComponent,
    children: [
      {path: 'administrator', component: AdministratorAccountComponent},
      {path: 'teacher', component: TeacherAccountComponent},
      {path: 'learner', component: LearnerAccountComponent}
    ]
  },
  {path: 'profil', component: ProfileComponent},
  {path: 'liste-domaines', component: DomainesFormationComponent},
  {path: 'liste-formations', component: FormationsComponent},
  {path: 'formations-catalogue', component: TrainingFieldComponent},
  {path: 'langages-programmation', component: ProgrammingLangagesComponent},
  {path: 'programming-langages-details/:id', component: ProgrammingLangagesItemComponent},
  {path: 'reseaux', component: ReseauxComponent},
  {path: 'gestion-projet', component: GestionProjetComponent},
  {path: 'systemes-exploitation', component: SystemesExploitationComponent},
  {path: 'contact', component: ContactComponent},
  {path: '', redirectTo: 'home', pathMatch: 'full'},
  // {path: '**', redirectTo: 'home'},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
