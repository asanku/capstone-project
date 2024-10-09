import { Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { RegistrationComponent } from './registration/registration.component';
import { PersonalComponent } from './personal/personal.component';
import { PersonalcoachComponent } from './personalcoach/personalcoach.component';
import { CoachprofComponent } from './coachprof/coachprof.component';
import { EditproathleteComponent } from './editproathlete/editproathlete.component';
import { DietComponent } from './diet/diet.component';
import { GoalComponent } from './goal/goal.component';
import { CoachassComponent } from './coachass/coachass.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { AthleteprofComponent } from './athleteprof/athleteprof.component';
import { AthleteassComponent } from './athleteass/athleteass.component';
import { EditprocoachComponent } from './editprocoach/editprocoach.component';

export const routes: Routes = [
    { path: '', redirectTo: 'home', pathMatch: 'full' },
    {path: 'home', component: HomeComponent},
    {path: 'login', component: LoginComponent},
    {path: 'registration', component: RegistrationComponent},
    {path: 'personal', component: PersonalComponent},
    {path: 'personalcoach', component: PersonalcoachComponent},
    {path: 'coachprof', component: CoachprofComponent},
    {path: 'editproathlete', component: EditproathleteComponent},
    {path: 'diet', component: DietComponent},
    {path: 'goal', component: GoalComponent},
    {path: 'coachass', component: CoachassComponent},
    {path: 'dashboard', component: DashboardComponent},
    {path: 'athleteass', component: AthleteassComponent},
    {path: 'editprocoach', component: EditprocoachComponent},
    {path: 'athleteprof', component: AthleteprofComponent}
    
];
