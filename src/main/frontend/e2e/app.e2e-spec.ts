import { AgilityCourseTrackerPage } from './app.po';

describe('agility-course-tracker App', () => {
  let page: AgilityCourseTrackerPage;

  beforeEach(() => {
    page = new AgilityCourseTrackerPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
