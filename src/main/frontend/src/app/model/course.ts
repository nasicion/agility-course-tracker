import {Run} from './run';

export  class Course {
  id : number = 0;
  judge : string ;
  date : Date;
  lenght : number;
  standardCourseTime : number;
  maximiumCourseTime : number;
  speed : number;
  runs : Run[];

  constructor(){}
}
