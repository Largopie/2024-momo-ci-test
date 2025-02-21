/** @type {import('ts-jest').JestConfigWithTsJest} **/
module.exports = {
  testEnvironment: 'jsdom',
  transform: {
    '^.+.tsx?$': ['ts-jest', {}],
  },
  testEnvironmentOptions: {
    customExportConditions: [''],
  },
  setupFiles: ['./jest.polyfills.js'],
};
