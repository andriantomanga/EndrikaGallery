package com.endrikagallery.model;

public record ArtistInfos(
        String githubId,
        String name,
        String email,
        String phone,
        Country country,
        String website) {

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String githubId;
        private String name;
        private String email;
        private String phone;
        private Country country;
        private String website;

        public Builder githubId(String githubId) {
            this.githubId = githubId;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder country(Country country) {
            this.country = country;
            return this;
        }

        public Builder website(String website) {
            this.website = website;
            return this;
        }

        public ArtistInfos build() {
            return new ArtistInfos(githubId, name, email, phone, country, website);
        }
    }
}
